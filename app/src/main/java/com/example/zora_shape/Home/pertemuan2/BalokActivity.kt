package com.example.zora_shape.Home.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.zora_shape.Database.AppDatabase
import com.example.zora_shape.Database.CalculationHistory
import com.example.zora_shape.R
import kotlinx.coroutines.launch

class BalokActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        supportActionBar?.title = "Rumus Balok"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etPanjang = findViewById<EditText>(R.id.etPanjang)
        val etLebar = findViewById<EditText>(R.id.etLebar)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        val db = AppDatabase.getDatabase(this)

        btnHitung.setOnClickListener {
            val pStr = etPanjang.text.toString()
            val lStr = etLebar.text.toString()
            val tStr = etTinggi.text.toString()
            
            val p = pStr.toDoubleOrNull()
            val l = lStr.toDoubleOrNull()
            val t = tStr.toDoubleOrNull()

            if (p != null && l != null && t != null) {
                val hasil = p * l * t
                val hasilStr = "Volume = $hasil"
                tvHasil.text = hasilStr

                // Save to Room Database
                lifecycleScope.launch {
                    db.calculationDao().insert(
                        CalculationHistory(
                            title = "Volume Balok",
                            input = "P: $pStr, L: $lStr, T: $tStr",
                            result = hasilStr
                        )
                    )
                    Toast.makeText(this@BalokActivity, "Riwayat disimpan", Toast.LENGTH_SHORT).show()
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