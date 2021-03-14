package com.pmacademy.catsapp.cats.data

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val avatarUrl: String
)
