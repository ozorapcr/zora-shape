package com.example.zora_shape.Home.pertemuan5

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportActionBar?.title = "Settings"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lvSettings = findViewById<ListView>(R.id.lvSettings)
        val settingsItems = arrayOf("Privacy Policy", "Terms of Service", "About App", "Help & Support", "Feedback", "Version 1.0.0")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, settingsItems)
        lvSettings.adapter = adapter

        lvSettings.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = settingsItems[position]
            Toast.makeText(this, "Membuka: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}