package com.mrwhoknows.dogimagegenerator.ui.view_dogs

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.dogimagegenerator.repo.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ViewDogsViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

    private val _dogImages = MutableLiveData<List<Bitmap>>()
    val dogImages: LiveData<List<Bitmap>> = _dogImages

    init {
        getRecentlyViewedDogBitmaps()
    }

    private fun getRecentlyViewedDogBitmaps() = viewModelScope.launch {
        val bitmaps = repository.getAllBitmapsFromCache()
        Timber.i("getRecentlyViewedDogBitmaps: ${bitmaps.size}")
        _dogImages.postValue(bitmaps)
    }
}