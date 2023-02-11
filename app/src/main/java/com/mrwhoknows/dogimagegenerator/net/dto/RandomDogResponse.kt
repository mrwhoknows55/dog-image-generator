package com.mrwhoknows.dogimagegenerator.net.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RandomDogResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val imageUrl: String
)
