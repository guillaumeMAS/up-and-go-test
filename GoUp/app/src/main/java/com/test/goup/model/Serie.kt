package com.test.goup.model

import com.google.gson.annotations.SerializedName

data class Serie(

    @SerializedName("_embedded")
    val embedded: Embedded
) {
    data class Embedded(

        @SerializedName("episodes")
        val episodes: List<Episode>
    )
}