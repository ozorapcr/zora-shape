package com.example.zora_shape.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zora_shape.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    // Daftar produk dengan gambar yang disesuaikan dengan tema Administrasi & Lembaga Desa
    private val productList = listOf(
        ProductModel("Data Perangkat Desa", "Informasi Aparatur", "https://picsum.photos/id/100/400/300"), // Kamera/arsip
        ProductModel("Lembaga Desa", "Struktur Organisasi", "https://picsum.photos/id/24/400/300"), // Gedung/bangunan
        ProductModel("Anggota Lembaga", "Detail Personil", "https://picsum.photos/id/91/400/300"), // Orang di kantor
        ProductModel("Data Wilayah RW", "Pemetaan Digital", "https://picsum.photos/id/104/400/300"), // Pemandangan desa
        ProductModel("Jabatan Lembaga", "Hierarki Resmi", "https://picsum.photos/id/20/400/300"), // Meja kerja
        ProductModel("Statistik Desa", "Grafik & Data", "https://picsum.photos/id/29/400/300"), // Kacamata/buku
        ProductModel("Laporan Kegiatan", "Dokumentasi Arsip", "https://picsum.photos/id/0/400/300"), // Kantor/laptop
        ProductModel("Pengumuman Desa", "Layanan Publik", "https://picsum.photos/id/96/400/300"), // Papan tulis
        ProductModel("Kartu Keluarga", "Data Kependudukan", "https://picsum.photos/id/26/400/300"), // Map/surat
        ProductModel("Surat Menyurat", "Administrasi Umum", "https://picsum.photos/id/134/400/300"), // Amplop surat
        ProductModel("Agenda Desa", "Jadwal Kegiatan", "https://picsum.photos/id/1/400/300"), // Buku catatan
        ProductModel("Inventaris Kantor", "Aset Desa", "https://picsum.photos/id/2/400/300") // Meja dan kursi kantor
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(requireContext(), "Membuka detail: ${selectedItem.name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}