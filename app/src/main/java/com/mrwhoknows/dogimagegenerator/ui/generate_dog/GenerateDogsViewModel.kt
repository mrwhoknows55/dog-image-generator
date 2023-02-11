package com.mrwhoknows.dogimagegenerator.ui.generate_dog

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
class GenerateDogsViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

    private val _randomImg = MutableLiveData<Bitmap>()
    val randomImg: LiveData<Bitmap> = _randomImg

    fun getRandomDogImage() = viewModelScope.launch {
        try {
            val url = repository.getRandomDogImgUrl()
            Timber.i(url)
            val bmp = repository.getBitmapFromUrl(url) ?: return@launch
            Timber.i(bmp.byteCount.toString())
            _randomImg.postValue(bmp)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}