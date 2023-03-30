package com.example.month6lesson2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.month6lesson2.adapter.SelectedImagesAdapter
import com.example.month6lesson2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity(){
private lateinit var recyclerView: RecyclerView
private lateinit var selectedImages: ArrayList<ImageItem>
private lateinit var adapter: SelectedImagesAdapter

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)

    recyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)


    selectedImages = intent.getParcelableArrayListExtra("selectedImages") ?: ArrayList()


    adapter = SelectedImagesAdapter(selectedImages)
    recyclerView.adapter = adapter
}
}
