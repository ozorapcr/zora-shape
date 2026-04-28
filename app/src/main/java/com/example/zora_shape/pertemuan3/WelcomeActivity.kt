package com.example.zora_shape.pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.MainActivity
import com.example.zora_shape.databinding.ActivityWelcomeBinding
import com.example.zora_shape.pertemuan3.pertemuan_5.WebViewActivity
import com.example.zora_shape.pertemuan4.Custom1Activity
import com.example.zora_shape.pertemuan4.Custom2Activity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME") ?: "User"
        binding.tvWelcomeUser.text = "Halo, $username!"

        // 1. Tombol Rumus
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // 2. Tombol Custom 1
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom1Activity::class.java)
            intent.putExtra("title", "Halaman Custom 1")
            startActivity(intent)
        }

        // 3. Tombol Custom 2 (Tetap Ada)
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("title", "Halaman Custom 2")
            startActivity(intent)
        }

        // 4. Tombol Web Bina Desa
        binding.btnWeb.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // 5. Tombol Logout
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    getSharedPreferences("user_pref", MODE_PRIVATE).edit().clear().apply()
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }
}