package com.example.zora_shape.pertemuan4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.databinding.ActivityCustom2Binding

class Custom2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvDesc.text = intent.getStringExtra("desc")

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}