package com.test.goup.preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.goup.model.Episode

class SharedPrefsImpl(
    private val sharedPreferences: SharedPreferences
) : SharedPrefs {

    private lateinit var episodes: List<Episode>

    private val gson = Gson()


    init {
        load()
    }

    override fun hasEpisodes(): Boolean {
        return episodes.isNotEmpty()
    }

    override fun setEpisodes(episodes: List<Episode>) {
        save(episodes)
    }

    override fun getEpisodes(): List<Episode> {
        return episodes
    }

    private fun load() {
        val episodesString = sharedPreferences.getString(KEY_EPISODES_PREFERENCES, "[]")
        episodes = gson.fromJson<List<Episode>>(
            episodesString,
            object : TypeToken<List<Episode>>() {}.type
        )
    }

    private fun save(episodes: List<Episode>) {
        val episodesString = gson.toJson(episodes, object : TypeToken<List<Episode>>() {}.type)
        sharedPreferences.edit().putString(KEY_EPISODES_PREFERENCES, episodesString).apply()
    }

    companion object {

        val SHARED_PREFS_NAME = "shared_preferences"
        private val KEY_EPISODES_PREFERENCES = "episodes"
    }
}