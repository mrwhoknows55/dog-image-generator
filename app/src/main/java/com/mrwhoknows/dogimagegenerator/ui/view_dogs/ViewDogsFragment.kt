package com.mrwhoknows.dogimagegenerator.ui.view_dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mrwhoknows.dogimagegenerator.databinding.FragmentViewDogsBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ViewDogsFragment : Fragment() {

    private lateinit var binding: FragmentViewDogsBinding
    private val viewModel by viewModels<ViewDogsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewDogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.dogImages.observe(viewLifecycleOwner) {
            Timber.i("dogImages(${it.size}): $it")
        }
    }
}