package com.example.zora_shape

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.R.id

class SegitigaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segitiga)

        // Tambahan Judul Toolbar
        supportActionBar?.title = "Rumus Segitiga"

        // Tambahan Tombol Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etAlas = findViewById<EditText>(id.etAlas)
        val etTinggi = findViewById<EditText>(id.etTinggi)
        val btnHitung = findViewById<Button>(id.btnHitung)
        val tvHasil = findViewById<TextView>(id.tvHasil)

        btnHitung.setOnClickListener {
            val alas = etAlas.text.toString().toDoubleOrNull()
            val tinggi = etTinggi.text.toString().toDoubleOrNull()

            if (alas != null && tinggi != null) {
                val hasil = 0.5 * alas * tinggi
                tvHasil.text = "Luas = $hasil"

                Log.d("SEGITIGA", "Hasil: $hasil")
            } else {
                Toast.makeText(this, "Input tidak valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Tambahan fungsi tombol back toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}