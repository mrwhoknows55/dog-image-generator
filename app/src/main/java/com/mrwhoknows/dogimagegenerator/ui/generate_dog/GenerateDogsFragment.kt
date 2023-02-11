package com.mrwhoknows.dogimagegenerator.ui.generate_dog

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.mrwhoknows.dogimagegenerator.databinding.FragmentGenerateDogsBinding
import com.mrwhoknows.dogimagegenerator.util.Resource
import com.mrwhoknows.dogimagegenerator.util.setSafeOnClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenerateDogsFragment : Fragment() {
    private lateinit var binding: FragmentGenerateDogsBinding
    private val viewModel by viewModels<GenerateDogsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenerateDogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        setupObservers()
    }

    private fun setupClickListeners() {
        binding.btnGenerate.setSafeOnClickListener {
            viewModel.getRandomDogImage()
        }
    }

    private fun setupObservers() {
        viewModel.randomImg.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> updateSuccessUI(it.data)
                is Resource.Loading -> updateLoadingUI(true)
                is Resource.Error -> updateErrorUI(it.message)
            }

        }
    }

    private fun updateSuccessUI(data: Bitmap?) {
        updateLoadingUI(false)
        data?.let {
            binding.ivDog.setImageBitmap(it)
        }
    }

    private fun updateLoadingUI(isLoading: Boolean) {
        binding.apply {
            if (isLoading) {
                ivDog.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
                ivDog.visibility = View.VISIBLE
            }
        }
    }

    private fun updateErrorUI(message: String?) {
        updateLoadingUI(false)
        Snackbar.make(binding.root, message ?: "Something Went Wrong", Snackbar.LENGTH_SHORT).show()
    }

}