package com.example.fifthweekapppt3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fifthweekapppt3.R
import com.example.fifthweekapppt3.data.api.CatAPI
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class FavouriteCatsActivity : AppCompatActivity() {
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_cats)
        getSupportActionBar()?.hide()
        val recycler = findViewById<RecyclerView>(R.id.recycler_favourite)
        val adapter = FavouriteCatsAdapter()
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        scope.launch {
           adapter.setData(CatAPI.getLiked().reversed())
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}