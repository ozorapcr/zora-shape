package com.example.zora_shape

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.zora_shape.Home.pertemuan3.LoginActivity
import com.example.zora_shape.Onboarding.OnboardingActivity
import com.example.zora_shape.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Glide.with(this)
            .load(R.drawable.logorw)
            .into(binding.imgLogoSplash)

        Handler(Looper.getMainLooper()).postDelayed({

            val spUser = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = spUser.getBoolean("isLogin", false)
            val username = spUser.getString("username", "")

            val spOnboarding = getSharedPreferences("onboarding_pref", MODE_PRIVATE)
            val isOnboardingCompleted = spOnboarding.getBoolean("isCompleted", false)

            if (isLogin) {
                val intent = Intent(this, BaseActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            } else if (!isOnboardingCompleted) {
                startActivity(Intent(this, OnboardingActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            finish()

        }, 3000)
    }
}