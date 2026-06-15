package com.example.zora_shape.Home.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.zora_shape.Database.AppDatabase
import com.example.zora_shape.Database.CalculationHistory
import com.example.zora_shape.R
import kotlinx.coroutines.launch

class SegitigaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segitiga)

        supportActionBar?.title = "Rumus Segitiga"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etAlas = findViewById<EditText>(R.id.etAlas)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        val db = AppDatabase.getDatabase(this)

        btnHitung.setOnClickListener {
            val alasStr = etAlas.text.toString()
            val tinggiStr = etTinggi.text.toString()
            val alas = alasStr.toDoubleOrNull()
            val tinggi = tinggiStr.toDoubleOrNull()

            if (alas != null && tinggi != null) {
                val hasil = 0.5 * alas * tinggi
                val hasilStr = "Luas = $hasil"
                tvHasil.text = hasilStr

                // Save to Room Database
                lifecycleScope.launch {
                    db.calculationDao().insert(
                        CalculationHistory(
                            title = "Luas Segitiga",
                            input = "Alas: $alasStr, Tinggi: $tinggiStr",
                            result = hasilStr
                        )
                    )
                    Toast.makeText(this@SegitigaActivity, "Riwayat disimpan", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Input tidak valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}