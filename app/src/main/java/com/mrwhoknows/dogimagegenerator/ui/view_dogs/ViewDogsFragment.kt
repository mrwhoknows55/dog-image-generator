package com.mrwhoknows.dogimagegenerator.ui.view_dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.mrwhoknows.dogimagegenerator.databinding.FragmentViewDogsBinding
import com.mrwhoknows.dogimagegenerator.util.setSafeOnClickListener
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ViewDogsFragment : Fragment() {

    private lateinit var binding: FragmentViewDogsBinding
    private val viewModel by viewModels<ViewDogsViewModel>()
    private val adapter by lazy { DogImagesListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewDogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupClickListeners()
        setupObservers()
    }

    private fun setupUI() {
        binding.rvDogsList.apply {
            adapter = this@ViewDogsFragment.adapter
            layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
        }
    }

    private fun setupClickListeners() {
        binding.btnClearDogs.setSafeOnClickListener {
            viewModel.clearDogs()
        }
    }

    private fun setupObservers() {
        viewModel.dogImages.observe(viewLifecycleOwner) {
            Timber.i("dogImages(${it.size}): $it")
            adapter.submitList(it)
        }
    }
}