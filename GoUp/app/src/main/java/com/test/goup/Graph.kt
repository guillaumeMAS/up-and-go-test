package com.test.goup

import android.content.Context
import com.test.goup.network.NetworkModule
import com.test.goup.preferences.SharedPrefs
import com.test.goup.preferences.SharedPrefsModule

class Graph(
    private val app: App
) {

    private val sharedPrefsModule = SharedPrefsModule()
    private val sharedPrefs by lazy { sharedPrefsModule.createSharedPrefs() }

    private val networkModule = NetworkModule()
    private val networkService by lazy { networkModule.createNetworkManager() }

    fun provideContext(): Context = app.baseContext
    fun provideSharedPrefs() = sharedPrefs
    fun provideNetworkService() = networkService
}