package com.example.zora_shape.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.BalokActivity
import com.example.zora_shape.SegitigaActivity
import com.example.zora_shape.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        binding.tvTitle.text = title
        binding.tvDesc.text = desc

        Log.e("IntentData", "Title: $title, Desc: $desc")

        // KE BALOK
        binding.btnBalok.setOnClickListener {
            startActivity(Intent(this, BalokActivity::class.java))
        }

        // KE SEGITIGA
        binding.btnSegitiga.setOnClickListener {
            startActivity(Intent(this, SegitigaActivity::class.java))
        }

        // KEMBALI
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}