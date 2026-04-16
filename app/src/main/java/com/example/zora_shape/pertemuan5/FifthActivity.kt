package com.example.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout

class FifthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appBar = findViewById<AppBarLayout>(R.id.appBar)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Dashboard"
            setDisplayHomeAsUpEnabled(true)
        }

        // Animasi fade toolbar
        appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val alpha = 1.0f - (Math.abs(verticalOffset) / appBarLayout.totalScrollRange.toFloat())
            toolbar.alpha = alpha
        }

        findViewById<Button>(R.id.btnWebView).setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.sub_profile -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.sub_logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}