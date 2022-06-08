package com.test.goup.preferences

import android.content.Context
import com.test.goup.App

class SharedPrefsModule {

    fun createSharedPrefs(): SharedPrefs {
        val context = App.graph().provideContext()
        val sharedPreferences = context.getSharedPreferences(
            SharedPrefsImpl.SHARED_PREFS_NAME,
            Context.MODE_PRIVATE
        )
        return SharedPrefsImpl(sharedPreferences)
    }
}