package com.example.zora_shape.Home.pertemuan5

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.zora_shape.Notification.NotificationReceiver
import com.example.zora_shape.Notification.PermissionHelper
import com.example.zora_shape.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class DesaActivity : AppCompatActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(this, "Izin notifikasi diberikan", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Izin notifikasi ditolak", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desa)

        supportActionBar?.title = "Bina Desa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnSubmit = findViewById<MaterialButton>(R.id.btnSubmit)
        val btnSettings = findViewById<MaterialButton>(R.id.btnGoToSettings)
        val btnSetReminder = findViewById<MaterialButton>(R.id.btnSetReminder)
        val etReminderMinutes = findViewById<TextInputEditText>(R.id.etReminderMinutes)

        btnSubmit.setOnClickListener {
            Toast.makeText(this, "Laporan Anda telah dikirim. Terima kasih!", Toast.LENGTH_LONG).show()
            showInstantNotification(
                "Laporan Terkirim",
                "Terima kasih atas laporan Anda di Program Bina Desa."
            )
        }

        btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnSetReminder.setOnClickListener {
            val minutesStr = etReminderMinutes.text.toString()
            if (minutesStr.isNotEmpty()) {
                val minutes = minutesStr.toInt()
                checkNotificationPermissionAndSetReminder(minutes)
            } else {
                Toast.makeText(this, "Silahkan masukkan jumlah menit", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showInstantNotification(title: String, message: String) {
        val intent = Intent(this, NotificationReceiver::class.java).apply {
            putExtra("title", title)
            putExtra("message", message)
        }
        sendBroadcast(intent)
    }

    private fun checkNotificationPermissionAndSetReminder(minutes: Int) {
        if (PermissionHelper.isNotificationPermissionRequired()) {
            if (PermissionHelper.hasPermission(this, Manifest.permission.POST_NOTIFICATIONS)) {
                scheduleReminder(minutes)
            } else {
                PermissionHelper.requestPermission(requestPermissionLauncher, Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            scheduleReminder(minutes)
        }
    }

    private fun scheduleReminder(minutes: Int) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, NotificationReceiver::class.java).apply {
            putExtra("title", "Musyawarah Desa")
            putExtra("message", "Waktunya mengikuti musyawarah desa di balai desa.")
        }

        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val triggerTime = System.currentTimeMillis() + (minutes * 60 * 1000)

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerTime,
                    pendingIntent
                )
            } else {
                alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    triggerTime,
                    pendingIntent
                )
            }
            Toast.makeText(this, "Pengingat diatur untuk $minutes menit lagi", Toast.LENGTH_SHORT).show()
        } catch (e: SecurityException) {
            Toast.makeText(this, "Gagal mengatur pengingat: Izin alarm tidak tersedia", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}