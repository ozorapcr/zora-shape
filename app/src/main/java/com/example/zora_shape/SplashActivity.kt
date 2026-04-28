package com.example.zora_shape

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.pertemuan3.LoginActivity
import com.example.zora_shape.pertemuan3.WelcomeActivity // Tambahkan import ini

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({

            val sp = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sp.getBoolean("isLogin", false)
            val username = sp.getString("username", "")

            if (isLogin) {
                // Jika sudah login, lempar ke WelcomeActivity (bukan MainActivity)
                // agar user disambut dengan nama mereka.
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            finish()

        }, 3000) // 3 detik cukup untuk user melihat logo & progress bar
    }
}