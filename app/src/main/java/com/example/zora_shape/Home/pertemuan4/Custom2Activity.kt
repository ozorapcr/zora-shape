package com.example.zora_shape.Home.pertemuan4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.zora_shape.R
import com.example.zora_shape.databinding.ActivityCustom2Binding

class Custom2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use Glide to load the image to avoid "Canvas: trying to draw too large bitmap"
        Glide.with(this)
            .load(R.drawable.logo_home)
            .into(binding.imgCustom)

        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvDesc.text = intent.getStringExtra("desc")

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}