package com.example.zora_shape.pertemuan3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")

        binding.tvWelcomeUser.text = if (!username.isNullOrEmpty()) {
            "Halo, $username!\nSelamat datang di aplikasi Home Decor."
        } else {
            "Selamat datang di aplikasi Home Decor."
        }
    }
}