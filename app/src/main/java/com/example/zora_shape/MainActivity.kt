package com.example.zora_shape

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zora_shape.pertemuan3.pertemuan_5.WebViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Mengaktifkan fitur tampilan layar penuh
        enableEdgeToEdge()

        // 2. Menghubungkan ke layout activity_main.xml
        setContentView(R.layout.activity_main)

        // Tambahan Langkah 6
        supportActionBar?.title = "Bina Desa"

        // Tambahan Langkah 7 (Tombol Back di Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 3. Menangani Window Insets (Padding Status Bar/Navbar)
        // Sekarang aman karena di XML sudah ada android:id="@+id/main"
        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 4. Inisialisasi Tombol berdasarkan ID di XML baru
// Di dalam MainActivity.kt, cukup sisakan ini untuk navigasi:
        val btnSegitiga = findViewById<Button>(R.id.button)
        val btnBalok = findViewById<Button>(R.id.button2)
        val btnExit = findViewById<Button>(R.id.button3)

        btnSegitiga.setOnClickListener {
            startActivity(Intent(this, SegitigaActivity::class.java))
        }

        btnBalok.setOnClickListener {
            startActivity(Intent(this, BalokActivity::class.java))
        }

        btnExit.setOnClickListener {
            finish() // Ini akan kembali ke WelcomeActivity
        }
    }

    // Tambahan Langkah 7 (Saat tombol back toolbar ditekan)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}