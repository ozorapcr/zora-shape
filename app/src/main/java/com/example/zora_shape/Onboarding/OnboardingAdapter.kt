package com.example.zora_shape.Onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zora_shape.R
import com.example.zora_shape.databinding.ItemOnboardingBinding

class OnboardingAdapter(private val activity: AppCompatActivity) :
    RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val titles = listOf(
        "Selamat Datang di Bina Desa",
        "Informasi Desa Digital",
        "Membangun Bersama"
    )

    private val descriptions = listOf(
        "Aplikasi yang membantu pengelolaan data desa secara digital dan terstruktur untuk kemajuan desa kita.",
        "Dapatkan akses informasi perangkat desa, lembaga, dan wilayah dengan lebih mudah dan cepat.",
        "Mari bersama-sama membangun desa digital yang lebih modern dan informatif bagi seluruh masyarakat."
    )

    private val images = listOf(
        R.drawable.logorw,
        R.drawable.logorw,
        R.drawable.logorw
    )

    class OnboardingViewHolder(val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.binding.tvTitle.text = titles[position]
        holder.binding.tvDesc.text = descriptions[position]
        
        // Optimasi Glide: override ukuran untuk mencegah "too large bitmap"
        Glide.with(holder.itemView.context)
            .load(images[position])
            .override(600, 600) // Memaksa ukuran bitmap jadi maksimal 600x600 px
            .into(holder.binding.imgOnboarding)
    }

    override fun getItemCount(): Int = titles.size
}