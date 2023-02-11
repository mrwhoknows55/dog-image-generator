package com.mrwhoknows.dogimagegenerator.ui.generate_dog

import androidx.lifecycle.ViewModel
import com.mrwhoknows.dogimagegenerator.repo.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenerateDogsViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

}