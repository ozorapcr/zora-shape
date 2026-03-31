package com.example.zora_shape

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 🔽 TAMBAHAN KITA DI SINI
        val btnSegitiga = findViewById<Button>(R.id.button)
        val btnBalok = findViewById<Button>(R.id.button2)
        val btnExit = findViewById<Button>(R.id.button3)

        // Pindah ke SegitigaActivity
        btnSegitiga.setOnClickListener {
            val intent = Intent(this, SegitigaActivity::class.java)
            startActivity(intent)
        }
        // Pindah ke BalokActivity
        btnBalok.setOnClickListener {
            val intent = Intent(this, BalokActivity::class.java)
            startActivity(intent)
        }

        // Exit
        btnExit.setOnClickListener {
            finish()
        }
    }
}