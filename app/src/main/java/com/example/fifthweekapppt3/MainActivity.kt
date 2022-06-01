package com.example.fifthweekapppt3

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import com.example.fifthweekapppt3.data.api.CatAPI
import com.example.fifthweekapppt3.data.model.CatItem
import com.example.fifthweekapppt3.data.model.FavouriteCats
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Dispatchers.Main)
    private var cat:ImageView? = null
    private var item:CatItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide();
        cat = findViewById<ImageView>(R.id.img_cat)
        val dislike = findViewById<ImageButton>(R.id.dislike)
        val favourites = findViewById<ImageButton>(R.id.favourites)
        val like = findViewById<ImageButton>(R.id.like)
        dislike.setOnClickListener { loadNewImage() }
        like.setOnClickListener {
            saveLike(item!!)
            loadNewImage()
        }



        scope.launch {
            val item = CatAPI.getNewImage()
            val uri = Uri.parse(item.url)
            cat?.setImageURI(uri)
        }

    }



    private fun loadNewImage(){
        scope.launch {
            cat?.setImageResource(R.drawable.ic_loading)
            item = CatAPI.getNewImage()
            val uri = Uri.parse(item?.url)
            cat?.setImageURI(uri)

        }
    }
    private fun saveLike (item: CatItem){
//        var cat:FavouriteCats? = null
//        cat.image_id = item.id

        scope.launch {
//            CatAPI.saveLike(!! cat)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}


