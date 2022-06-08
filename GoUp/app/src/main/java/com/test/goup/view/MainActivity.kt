package com.test.goup.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.test.goup.App
import com.test.goup.R
import com.test.goup.model.Serie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val sharedPrefs = App.graph().provideSharedPrefs()
        val networkService = App.graph().provideNetworkService()

        Log.d("HERE", sharedPrefs.hasEpisodes().toString())
        if (!sharedPrefs.hasEpisodes()) {
            networkService.getData().enqueue(object : Callback<Serie> {
                override fun onFailure(call: Call<Serie>, t: Throwable) {
                    Log.d("HERE Fail", call.request().body().toString())
                }

                override fun onResponse(
                    call: Call<Serie>,
                    response: Response<Serie>
                ) {
                    Log.d("HERE success", call.request().body().toString())
                    sharedPrefs.setEpisodes(response.body()!!.embedded.episodes)
                }

            })
        }
        Log.d("HERE", sharedPrefs.getEpisodes().toString())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}