package com.example.month6lesson2.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.month6lesson2.ImageItem
import com.example.month6lesson2.R

class ImageAdapter(private val context: Context, private val images: List<Uri>) :
RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val selectedImages = mutableSetOf<Uri>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUri = images[position]
        holder.bind(imageUri, selectedImages.contains(imageUri))
        holder.itemView.setOnClickListener {
            holder.toggleSelection(imageUri)
        }
    }

    fun getSelectedImages(): Set<Uri> {
        return selectedImages
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(uri: Uri, isSelected: Boolean) {
            imageView.setImageURI(uri)
            if (isSelected) {
                imageView.alpha = 0.5f
            } else {
                imageView.alpha = 1f
            }
        }

        fun toggleSelection(uri: Uri) {
            if (selectedImages.contains(uri)) {
                selectedImages.remove(uri)
                imageView.alpha = 1f
            } else {
                selectedImages.add(uri)
                imageView.alpha = 0.5f
            }
        }
    }
}