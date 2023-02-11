package com.mrwhoknows.dogimagegenerator.repo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mrwhoknows.dogimagegenerator.cache.LRUCache
import com.mrwhoknows.dogimagegenerator.net.DogApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import timber.log.Timber
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val apiService: DogApiService,
    private val okHttpClient: OkHttpClient,
    private val lruCache: LRUCache<String, Bitmap>
) {

    suspend fun getRandomDogImgUrl(): String = withContext(Dispatchers.IO) {
        apiService.getRandomDogImage().imageUrl
    }

    suspend fun getBitmapFromUrl(url: String): Bitmap? = withContext(Dispatchers.IO) {
        val bmpFromCache = lruCache.get(url)
        bmpFromCache?.let {
            return@withContext it
        }
        val req = Request.Builder().url(url).build()
        val res = okHttpClient.newCall(req).execute()
        val bmpFromUrl = BitmapFactory.decodeStream(res.body?.byteStream())
        bmpFromUrl?.let { lruCache.put(url, it) }
        bmpFromUrl
    }

    fun getAllBitmapsFromCache(): List<Bitmap> = lruCache.getAllValues()

}