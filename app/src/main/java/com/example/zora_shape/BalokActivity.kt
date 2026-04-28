package com.example.zora_shape

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BalokActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        // Tambahan Judul Toolbar
        supportActionBar?.title = "Rumus Balok"

        // Tambahan Tombol Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etPanjang = findViewById<EditText>(R.id.etPanjang)
        val etLebar = findViewById<EditText>(R.id.etLebar)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnHitung.setOnClickListener {
            val p = etPanjang.text.toString().toDoubleOrNull()
            val l = etLebar.text.toString().toDoubleOrNull()
            val t = etTinggi.text.toString().toDoubleOrNull()

            if (p != null && l != null && t != null) {
                val hasil = p * l * t
                tvHasil.text = "Volume = $hasil"

                Log.d("BALOK", "Hasil: $hasil")
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