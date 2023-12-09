package com.fatemeh.digitoon.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fatemeh.digitoon.R
import com.fatemeh.digitoon.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel {
        parametersOf(

           args.imdbId
        )
    }
    private val binding: FragmentDetailBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
        val imdbId = args.imdbId

        detailViewModel.detailLiveData.observe(viewLifecycleOwner) {

            Picasso.get().load(it.poster).into(binding.ivPoster)


            binding.tvTitle.text = it.title
            binding.tvYear.text = it.year
            binding.tvRuntime.text = it.runtime
            binding.tvImdbRating.text = it.imdbRating
            binding.tvGenre.text = it.genre
            binding.tvDirector.text = it.director
            binding.tvWriter.text = it.writer
            binding.tvActors.text = it.actors
            binding.tvType.text = it.type
            binding.tvRated.text = it.rated
            binding.tvReleased.text = it.released
            binding.tvPlot.text = it.plot
            binding.tvLanguage.text = it.language
            binding.tvCountry.text = it.country
            binding.tvAwards.text = it.awards
            binding.tvMetascore.text = it.metascore
            binding.tvImdbVotes.text = it.imdbVotes
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}