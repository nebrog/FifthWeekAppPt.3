package com.example.fifthweekapppt3.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fifthweekapppt3.R
import com.example.fifthweekapppt3.data.model.GetFavCatsItem

class FavouriteCatsAdapter : RecyclerView.Adapter<FavouriteCatsAdapter.CatsViewHolder>() {
    private var catsList = ArrayList<GetFavCatsItem>()

    fun setData(cats: List<GetFavCatsItem>) {
        catsList.clear()
        catsList.addAll(cats)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return CatsViewHolder(item)
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val catItem = catsList[position]
        holder.onBind(catItem)
    }

    override fun getItemCount(): Int {
        return catsList.size
    }

    class CatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img = itemView.findViewById<ImageView>(R.id.img_cat)
        fun onBind(cat: GetFavCatsItem) {
            val uri = Uri.parse(cat.image.url)
            img.setImageURI(uri)
        }

    }
}