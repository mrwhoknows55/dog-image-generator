package com.mrwhoknows.dogimagegenerator.net

import com.mrwhoknows.dogimagegenerator.net.dto.RandomDogResponse
import retrofit2.http.GET

interface DogApiService {
    @GET("/api/breeds/image/random")
    suspend fun getRandomDogImage(): RandomDogResponse
}