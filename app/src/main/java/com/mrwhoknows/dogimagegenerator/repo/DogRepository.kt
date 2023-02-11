package com.mrwhoknows.dogimagegenerator.repo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mrwhoknows.dogimagegenerator.net.DogApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val apiService: DogApiService,
    private val okHttpClient: OkHttpClient
) {

    suspend fun getRandomDogImgUrl(): String = withContext(Dispatchers.IO) {
        apiService.getRandomDogImage().imageUrl
    }

    suspend fun getBitmapFromUrl(url: String): Bitmap? = withContext(Dispatchers.IO){
        val req = Request.Builder().url(url).build()
        val res = okHttpClient.newCall(req).execute()
        BitmapFactory.decodeStream(res.body?.byteStream())
    }

}