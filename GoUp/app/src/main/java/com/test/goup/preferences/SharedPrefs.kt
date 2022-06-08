package com.test.goup.preferences

import com.test.goup.model.Episode

interface SharedPrefs {

    fun hasEpisodes(): Boolean

    fun setEpisodes(episodes: List<Episode>)

    fun getEpisodes(): List<Episode>
}