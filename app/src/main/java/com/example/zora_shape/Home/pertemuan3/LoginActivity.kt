package com.example.zora_shape.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.zora_shape.BaseActivity
import com.example.zora_shape.R
import com.example.zora_shape.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cek Session
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        if (sharedPref.getBoolean("isLogin", false)) {
            moveToWelcome(sharedPref.getString("username", ""))
            return
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use Glide to load the large logo to avoid "Canvas: trying to draw too large bitmap"
        Glide.with(this)
            .load(R.drawable.logorw)
            .into(binding.imgLogo)

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnKirim.setOnClickListener {
            val username = binding.inputNoTujuan.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan Login
            sharedPref.edit().apply {
                putBoolean("isLogin", true)
                putString("username", username)
                apply()
            }

            moveToWelcome(username)
        }
    }

    private fun moveToWelcome(username: String?) {
        val intent = Intent(this, BaseActivity::class.java)
        intent.putExtra("USERNAME", username)
        startActivity(intent)
        finish() // Penting: Agar tidak bisa back ke Login
    }
}