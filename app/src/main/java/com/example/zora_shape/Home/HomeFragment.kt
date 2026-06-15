package com.example.zora_shape.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zora_shape.Home.pertemuan2.MainActivity
import com.example.zora_shape.Home.pertemuan3.LoginActivity
import com.example.zora_shape.Home.pertemuan4.Custom1Activity
import com.example.zora_shape.Home.pertemuan4.Custom2Activity
import com.example.zora_shape.Home.pertemuan5.DesaActivity
import com.example.zora_shape.Home.pertemuan5.WebViewActivity
import com.example.zora_shape.databinding.FragmentHomeBinding
import com.example.zora_shape.pertemuan_10.TenthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = requireActivity().intent.getStringExtra("USERNAME") ?: "User"
        binding.tvWelcomeUser.text = "Halo, $username!"

        setupRecyclerView()
        fetchNews()

        binding.btnRumus.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        binding.btnCustom1.setOnClickListener {
            val intent = Intent(requireContext(), Custom1Activity::class.java)
            intent.putExtra("title", "Halaman Custom 1")
            startActivity(intent)
        }

        binding.btnCustom2.setOnClickListener {
            val intent = Intent(requireContext(), Custom2Activity::class.java)
            intent.putExtra("title", "Halaman Custom 2")
            startActivity(intent)
        }

        binding.btnDesa.setOnClickListener {
            startActivity(Intent(requireContext(), DesaActivity::class.java))
        }

        binding.btnWeb.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        binding.btnPertemuan10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    requireContext()
                        .getSharedPreferences("user_pref", MODE_PRIVATE)
                        .edit()
                        .clear()
                        .apply()

                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    private fun setupRecyclerView() {
        // Tambahkan lambda { news -> ... } setelah listOf()
        newsAdapter = NewsAdapter(listOf()) { news ->
            // SEMENTARA: Menampilkan toast saat item berita diklik
            Toast.makeText(requireContext(), "Kamu mengklik: ${news.title}", Toast.LENGTH_SHORT).show()
        }

        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }
    }

    private fun fetchNews() {
        binding.progressBarNews.visibility = View.VISIBLE
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val apiService = NewsApiService.create()
                val response = apiService.getTopHeadlines()
                if (response.articles.isNotEmpty()) {
                    newsAdapter.setData(response.articles)
                } else {
                    Toast.makeText(requireContext(), "Tidak ada berita terbaru", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal terhubung ke GNews: ${e.message}", Toast.LENGTH_SHORT).show()
            } finally {
                binding.progressBarNews.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}