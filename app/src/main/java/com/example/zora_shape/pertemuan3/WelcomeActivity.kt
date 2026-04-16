package com.example.zora_shape.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
// IMPORT ACTIVITY TUJUAN
import com.example.zora_shape.MainActivity // MainActivity yang di luar
import com.example.zora_shape.pertemuan4.Custom1Activity // Custom1 di pertemuan4
import com.example.zora_shape.pertemuan4.Custom2Activity // Custom2 di pertemuan4
// IMPORT BINDING & UI
import com.example.zora_shape.databinding.ActivityWelcomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data username dari intent sebelumnya (Login)
        val username = intent.getStringExtra("USERNAME")
        val welcomeText = if (!username.isNullOrEmpty()) {
            "Halo, $username!"
        } else {
            "Halo!"
        }
        binding.tvWelcomeUser.text = welcomeText

        val desc = binding.tvDesc.text.toString()

        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title", "Menu Bangun Ruang")
            intent.putExtra("desc", desc)
            startActivity(intent)
        }
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom1Activity::class.java)
            intent.putExtra("title", "Halaman Custom 1")
            intent.putExtra("desc", desc)
            startActivity(intent)
        }

        // ==========================================
        // TOMBOL 3 (btnCustom2) → Ke Custom2Activity (Pertemuan4)
        // ==========================================
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("title", "Halaman Custom 2")
            intent.putExtra("desc", desc)
            startActivity(intent)
        }

        // ==========================================
        // TOMBOL 4 → LOGOUT
        // ==========================================
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    // Kembali ke LoginActivity (ada di package pertemuan3 yang sama)
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // Tutup WelcomeActivity
                    Log.e("Logout", "Berhasil logout")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                    Log.e("Logout", "Dibatalkan")
                }
                .show()
        }
    }
}