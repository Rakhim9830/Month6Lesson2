package com.example.month6lesson2.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.month6lesson2.ImageItem
import com.example.month6lesson2.R

class SelectedImagesAdapter (private val selectedImages: List<ImageItem>) :
    RecyclerView.Adapter<SelectedImagesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = selectedImages[position]
        Glide.with(holder.itemView)
            .load(image.url)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return selectedImages.size
    }
}