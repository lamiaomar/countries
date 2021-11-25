package com.example.countries.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.countries.databinding.FragmentCountryBinding
import com.example.countries.network.Phototresponse


class CountryFragment : Fragment() {
    private val viewModel: CountryViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCountryBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the CountryViewModel
        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter()


        return binding.root
    }
}