package com.example.zora_shape.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            val username = binding.inputNoTujuan.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.inputNoTujuan.error = "Username / Email wajib diisi"
                binding.inputNoTujuan.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.inputPassword.error = "Password wajib diisi"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Login berhasil: $username", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
        }
    }
}