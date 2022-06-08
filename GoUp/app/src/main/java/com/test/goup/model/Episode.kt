package com.test.goup.model

import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("key_name")
    val name: String,

    @SerializedName("season")
    val season: Int,

    @SerializedName("number")
    val number: Int,

    @SerializedName("airtime")
    val airTIme: String,

    @SerializedName("airstamp")
    val airstamp: String,

    @SerializedName("runtime")
    val runtime: Int,

    @SerializedName("image")
    val image: Image,

    @SerializedName("summary")
    val summary: String
) {

    data class Image(
        @SerializedName("medium")
        val medium: String,

        @SerializedName("original")
        val original: String
    )
}