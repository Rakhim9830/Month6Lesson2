package com.example.month6lesson2

import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.month6lesson2.adapter.ImageAdapter
import com.example.month6lesson2.adapter.SelectedImagesAdapter
import com.example.month6lesson2.databinding.ActivityResultBinding
import android.graphics.drawable.Drawable as Drawable1

class ResultActivity : AppCompatActivity(){
    private lateinit var binding:ActivityResultBinding
    private lateinit var selectedImagesRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        selectedImagesRecyclerView = binding.recyclerView
        val selectedImages = intent.getParcelableArrayListExtra<Bitmap>( "selected_images")!!
        val selectedImagesAdapter = SelectedImagesAdapter(selectedImages) {  }
        selectedImagesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        selectedImagesRecyclerView.adapter = selectedImagesAdapter

    }

}
