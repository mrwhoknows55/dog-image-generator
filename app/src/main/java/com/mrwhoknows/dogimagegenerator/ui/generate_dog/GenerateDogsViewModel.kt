package com.mrwhoknows.dogimagegenerator.ui.generate_dog

import android.graphics.Bitmap
import androidx.core.util.lruCache
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.dogimagegenerator.repo.DogRepository
import com.mrwhoknows.dogimagegenerator.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GenerateDogsViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

    private val _randomImg = MutableLiveData<Resource<Bitmap>>()
    val randomImg: LiveData<Resource<Bitmap>> = _randomImg

    fun getRandomDogImage() = viewModelScope.launch {
        _randomImg.postValue(Resource.Loading())
        try {
            val url = repository.getRandomDogImgUrl()
            Timber.i(url)

            val bmp = repository.getBitmapFromUrl(url)
            Timber.i("bmp size: ${bmp?.byteCount}")

            if (bmp == null) {
                _randomImg.postValue(Resource.Error("Bitmap is null"))
                return@launch
            }
            _randomImg.postValue(Resource.Success(bmp))
        } catch (e: Exception) {
            Timber.e("getRandomDogImage: $e")
            _randomImg.postValue(Resource.Error(e.localizedMessage))
        }
    }
}