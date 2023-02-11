package com.mrwhoknows.dogimagegenerator.ui.generate_dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mrwhoknows.dogimagegenerator.databinding.FragmentGenerateDogsBinding
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

    private fun setupObservers() {
        viewModel.randomImg.observe(viewLifecycleOwner) {
            binding.ivDog.setImageBitmap(it)
        }
    }

    private fun setupClickListeners() {
        binding.btnGenerate.setSafeOnClickListener {
            viewModel.getRandomDogImage()
        }
    }
}