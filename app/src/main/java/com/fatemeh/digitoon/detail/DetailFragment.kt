package com.fatemeh.digitoon.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.fatemeh.digitoon.R
import com.fatemeh.digitoon.databinding.FragmentDetailBinding

class DetailFragment: Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding ?= null
    private val binding: FragmentDetailBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}