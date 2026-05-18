package com.example.zora_shape

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.zora_shape.Home.pertemuan3.LoginActivity
import com.example.zora_shape.Home.pertemuan3.WelcomeActivity
import com.example.zora_shape.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // Use Glide to load the large logo to avoid "Canvas: trying to draw too large bitmap"
        Glide.with(this)
            .load(R.drawable.logorw)
            .into(binding.imgLogoSplash)

        Handler(Looper.getMainLooper()).postDelayed({

            val sp = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sp.getBoolean("isLogin", false)
            val username = sp.getString("username", "")

            if (isLogin) {
                val intent = Intent(this, BaseActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            finish()

        }, 3000)
    }
}