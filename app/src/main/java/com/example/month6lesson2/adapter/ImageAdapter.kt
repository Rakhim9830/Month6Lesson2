package com.example.month6lesson2.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.month6lesson2.ImageItem
import com.example.month6lesson2.R

class ImageAdapter(private val images: List<Drawable>, private val onImageClickListener: (Drawable) -> Unit) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val selectedImages = mutableSetOf<Drawable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    fun getSelectedImages(): List<Drawable> = selectedImages.toList()

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(image: Drawable) {
            imageView.setImageDrawable(image)

            imageView.setOnClickListener {
                if (selectedImages.contains(image)) {
                    selectedImages.remove(image)
                    imageView.alpha = 1f
                } else {
                    selectedImages.add(image)
                    imageView.alpha = 0.5f
                }
            }

            onImageClickListener.invoke(image)
        }
    }
}