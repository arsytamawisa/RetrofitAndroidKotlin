package com.example.retrofit.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.retrofit.R
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private lateinit var viewModel: OverviewViewModel
    private lateinit var binding: FragmentOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(layoutInflater)
        binding.apply {
            textViewOverview.text = viewModel.response.value.toString()
        }
        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(OverviewViewModel::class.java)
    }
}