package com.example.zora_shape.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {

            val nama = binding.inputNama.text.toString().trim()
            val noHp = binding.inputNoHp.text.toString().trim()
            val username = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            // Validasi
            if (nama.isEmpty() || noHp.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 SIMPAN KE SHARED PREFERENCES
            saveUserToPref(username, password, nama, noHp)

            // Kirim ke OTP
            val intent = Intent(this, OtpActivity::class.java)
            intent.putExtra("NO_HP", noHp)
            startActivity(intent)
        }
    }

    // =========================
    // SHARED PREFERENCES
    // =========================
    private fun saveUserToPref(
        username: String,
        password: String,
        nama: String,
        noHp: String
    ) {
        val sharedPref = getSharedPreferences("USER_PREF", MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putString("USERNAME", username)
        editor.putString("PASSWORD", password)
        editor.putString("NAMA", nama)
        editor.putString("NO_HP", noHp)

        editor.apply()
    }
}