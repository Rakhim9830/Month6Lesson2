package com.example.month6lesson2
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.example.month6lesson2.adapter.ImageAdapter
import com.example.month6lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var adapter: ImageAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val imageList = listOf(
            Uri.parse("${R.drawable.img3}"),
            Uri.parse("${R.drawable.img_1}"),
            Uri.parse("${R.drawable.img2}"),
            Uri.parse("/${R.drawable.img4}"),
            Uri.parse("${R.drawable.img2}")
        )

        adapter = ImageAdapter(this, imageList)
        binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        binding.recyclerView.adapter = adapter


        val sendButton: Button = findViewById(R.id.buttonSend)
        sendButton.setOnClickListener {
            val selectedImages = adapter.getSelectedImages()
            if (selectedImages.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("selectedImages", ArrayList(selectedImages))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select at least one image", Toast.LENGTH_SHORT).show()
            }
        }
    }
}