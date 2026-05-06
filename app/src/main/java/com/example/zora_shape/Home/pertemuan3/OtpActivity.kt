package com.example.zora_shape.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.databinding.ActivityOtpBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class OtpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding
    private var noHp: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil No HP dari Register
        noHp = intent.getStringExtra("NO_HP")

        binding.btnVerifikasi.setOnClickListener {
            val otp = binding.inputOtp.text.toString().trim()

            if (otp.isEmpty()) {
                showError("Kode OTP tidak boleh kosong!")
            } else if (otp != noHp) {
                showError("Kode OTP salah!")
            } else {
                Toast.makeText(this, "Verifikasi Berhasil!", Toast.LENGTH_SHORT).show()

                // Lanjut (biasanya ke login atau welcome)
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun showError(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}