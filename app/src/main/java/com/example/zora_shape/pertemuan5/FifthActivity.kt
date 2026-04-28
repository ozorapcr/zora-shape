package com.example.zora_shape.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.zora_shape.R
import com.example.zora_shape.pertemuan3.pertemuan_5.WebViewActivity
import com.google.android.material.appbar.AppBarLayout
import kotlin.jvm.java

class FifthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        // 1. Inisialisasi View
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appBar = findViewById<AppBarLayout>(R.id.appBar)
        val btnWebView = findViewById<Button>(R.id.btnWebView)
        val btnMainMenu = findViewById<Button>(R.id.main_menu) // Menghubungkan ID main_menu dari XML

        // 2. Setup Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Dashboard"
            setDisplayHomeAsUpEnabled(true)
        }

        // 3. Animasi fade toolbar saat scroll
        appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val totalScroll = appBarLayout.totalScrollRange.toFloat()
            if (totalScroll > 0) {
                val alpha = 1.0f - (Math.abs(verticalOffset) / totalScroll)
                toolbar.alpha = alpha
            }
        }

        // 4. Logika Tombol WebView
        btnWebView.setOnClickListener {
            // Pastikan WebViewActivity sudah terdaftar di AndroidManifest.xml
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // 5. Logika Tombol Menu Utama (Fix untuk error sebelumnya)
        btnMainMenu.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke activity sebelumnya
            // Atau jika ingin ke Activity spesifik:
            // val intent = Intent(this, MainActivity::class.java)
            // startActivity(intent)
        }
    }

    // 6. Membuat Menu di Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Pastikan file res/menu/main_menu.xml sudah ada
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // 7. Logika saat item menu diklik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Membuka Pencarian", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.sub_profile -> {
                Toast.makeText(this, "Membuka Profil", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.sub_logout -> {
                Toast.makeText(this, "Berhasil Logout", Toast.LENGTH_SHORT).show()
                finish() // Menutup activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}