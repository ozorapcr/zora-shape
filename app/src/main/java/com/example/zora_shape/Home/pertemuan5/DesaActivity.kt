package com.example.zora_shape.Home.pertemuan5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.R
import com.google.android.material.button.MaterialButton

class DesaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desa)

        supportActionBar?.title = "Bina Desa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnSubmit = findViewById<MaterialButton>(R.id.btnSubmit)
        val btnSettings = findViewById<MaterialButton>(R.id.btnGoToSettings)

        btnSubmit.setOnClickListener {
            Toast.makeText(this, "Laporan Anda telah dikirim. Terima kasih!", Toast.LENGTH_LONG).show()
        }

        btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}