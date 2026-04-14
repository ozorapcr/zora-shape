package com.example.zora_shape

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Mengaktifkan fitur tampilan layar penuh
        enableEdgeToEdge()

        // 2. Menghubungkan ke layout activity_main.xml
        setContentView(R.layout.activity_main)

        // 3. Menangani Window Insets (Padding Status Bar/Navbar)
        // Sekarang aman karena di XML sudah ada android:id="@+id/main"
        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 4. Inisialisasi Tombol berdasarkan ID di XML baru
        val btnSegitiga = findViewById<Button>(R.id.button)
        val btnBalok = findViewById<Button>(R.id.button2)
        val btnExit = findViewById<Button>(R.id.button3)

        // Tombol Rumus Segitiga
        btnSegitiga.setOnClickListener {
            val intent = Intent(this, SegitigaActivity::class.java)
            startActivity(intent)
        }

        // Tombol Rumus Balok
        btnBalok.setOnClickListener {
            val intent = Intent(this, BalokActivity::class.java)
            startActivity(intent)
        }

        // Tombol Exit (Kembali ke WelcomeActivity)
        btnExit.setOnClickListener {
            finish()
        }
    }
}