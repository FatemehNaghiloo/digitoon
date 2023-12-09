package com.fatemeh.digitoon.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.fatemeh.digitoon.databinding.FragmentFilmBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmFragment : Fragment() {
    private var _binding: FragmentFilmBinding? = null
    private val binding: FragmentFilmBinding
        get() = _binding!!

    val filmViewModel: FilmViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFilmBinding.inflate(inflater, container, false)
        setupViews()
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setupViews() {

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        val rvFilm = binding.rvFilm
        rvFilm.layoutManager = gridLayoutManager
        //filmAdapter.onFilmClickListener = this


        filmViewModel.filmsLiveData.observe(viewLifecycleOwner) {
            val filmAdapter = it.search?.let { it1 ->
                FilmAdapter(it1) { imdbId ->
                    val action = FilmFragmentDirections.actionFilmFragmentToDetailFragment(imdbId)
                    findNavController().navigate(action)
                }
            }
            binding.rvFilm.adapter = filmAdapter
        }

        filmViewModel.progressBarLiveData.observe(viewLifecycleOwner) {
//            setProgressIndicator(it)
        }
    }

}