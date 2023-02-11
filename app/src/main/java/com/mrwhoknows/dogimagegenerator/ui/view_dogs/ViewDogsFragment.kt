package com.mrwhoknows.dogimagegenerator.ui.view_dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.google.android.material.snackbar.Snackbar
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
            Snackbar.make(binding.root, "All Dog Images Cleared", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupObservers() {
        viewModel.dogImages.observe(viewLifecycleOwner) {
            Timber.i("dogImages(${it.size}): $it")
            updateContentVisibility(it.isNotEmpty())
            adapter.submitList(it)
        }
    }

    private fun updateContentVisibility(isContentVisible: Boolean) {
        binding.apply {

            if (isContentVisible) {
                tvErrorMsg.visibility = View.GONE
                rvDogsList.visibility = View.VISIBLE
                btnClearDogs.visibility = View.VISIBLE
            } else {
                rvDogsList.visibility = View.GONE
                btnClearDogs.visibility = View.GONE
                tvErrorMsg.visibility = View.VISIBLE
            }
        }
    }
}