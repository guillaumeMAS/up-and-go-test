package com.test.goup

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        graph = Graph(this)
    }

    companion object {
        private lateinit var graph: Graph

        fun graph(): Graph {
            return graph
        }
    }
}