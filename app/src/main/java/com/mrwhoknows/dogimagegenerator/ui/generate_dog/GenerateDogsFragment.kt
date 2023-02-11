package com.mrwhoknows.dogimagegenerator.ui.generate_dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mrwhoknows.dogimagegenerator.databinding.FragmentGenerateDogsBinding

class GenerateDogsFragment : Fragment() {
    private lateinit var binding: FragmentGenerateDogsBinding
    private val viewModel by viewModels<GenerateDogsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenerateDogsBinding.inflate(inflater, container, false)
        return binding.root
    }
}