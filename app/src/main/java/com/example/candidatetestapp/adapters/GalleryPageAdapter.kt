package com.example.candidatetestapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.candidatetestapp.R
import com.example.candidatetestapp.models.Photo

class GalleryPageAdapter : RecyclerView.Adapter<GalleryPageAdapter.ViewHolder>() {
    private var photos = emptyList<Photo>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.gallery_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.gallery_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageBitmap(photos[position].photoBmp)
    }

    override fun getItemCount(): Int = photos.size

    fun setData(data: List<Photo>){
        this.photos = data
        notifyDataSetChanged()
    }
}