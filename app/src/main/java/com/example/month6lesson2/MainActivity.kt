package com.example.month6lesson2
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.month6lesson2.adapter.ImageAdapter
import com.example.month6lesson2.databinding.ActivityMainBinding
import com.example.month6lesson2.databinding.ActivityResultBinding

class MainActivity : AppCompatActivity(){

    private lateinit var imagesRecyclerView: RecyclerView
    private lateinit var submitImagesButton: Button

    private lateinit var imageAdapter: ImageAdapter


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imagesRecyclerView = binding.recyclerView
        submitImagesButton = binding.submitImagesButton

        val images = listOf(
            ContextCompat.getDrawable(this, R.drawable.img_1)!!,
            ContextCompat.getDrawable(this, R.drawable.img2)!!,
            ContextCompat.getDrawable(this, R.drawable.img3)!!,
            ContextCompat.getDrawable(this, R.drawable.img2)!!,
            ContextCompat.getDrawable(this, R.drawable.img_1)!!,
            ContextCompat.getDrawable(this, R.drawable.img3)!!
        )

        imageAdapter = ImageAdapter(images) { /* No-op */ }
        imagesRecyclerView.layoutManager = GridLayoutManager(this,3)
        imagesRecyclerView.adapter = imageAdapter

        submitImagesButton.setOnClickListener {
            val selectedImages = imageAdapter.getSelectedImages()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putParcelableArrayListExtra("selected_images", ArrayList(selectedImages))
            startActivity(intent)
        }
    }
}

private fun Intent.putParcelableArrayListExtra(s: String, arrayList: java.util.ArrayList<Drawable>) {

}
