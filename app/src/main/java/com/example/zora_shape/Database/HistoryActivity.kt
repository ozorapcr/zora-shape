package com.example.zora_shape.Database

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zora_shape.databinding.ActivityHistoryBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Riwayat Perhitungan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        db = AppDatabase.getDatabase(this)
        setupRecyclerView()
        observeHistory()

        binding.btnClearHistory.setOnClickListener {
            showDeleteConfirmation()
        }
    }

    private fun setupRecyclerView() {
        historyAdapter = HistoryAdapter(listOf())
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = historyAdapter
        }
    }

    private fun observeHistory() {
        lifecycleScope.launch {
            db.calculationDao().getAllHistory().collect { history ->
                if (history.isEmpty()) {
                    binding.tvEmpty.visibility = View.VISIBLE
                    binding.rvHistory.visibility = View.GONE
                } else {
                    binding.tvEmpty.visibility = View.GONE
                    binding.rvHistory.visibility = View.VISIBLE
                    historyAdapter.setData(history)
                }
            }
        }
    }

    private fun showDeleteConfirmation() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Hapus Semua")
            .setMessage("Yakin ingin menghapus semua riwayat?")
            .setPositiveButton("Hapus") { _, _ ->
                lifecycleScope.launch {
                    db.calculationDao().deleteAll()
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}