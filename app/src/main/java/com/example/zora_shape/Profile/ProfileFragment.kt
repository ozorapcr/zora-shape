package com.example.zora_shape.Profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.zora_shape.R
import com.example.zora_shape.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    // GANTI LINK INI DENGAN LINK KAMU SENDIRI
    private val githubUrl = "https://github.com/ozorapcr"
    private val linkedinUrl = "https://www.linkedin.com/in/ozorafeonasurya/"
    private val instagramUrl = "https://www.instagram.com/ozorafeonasrya_"
    private val whatsappUrl = "https://wa.me/6282286304303"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use Glide to load the large image to avoid "Canvas: trying to draw too large bitmap"
        Glide.with(this)
            .load(R.mipmap.ic_launcher)
            .into(binding.imgProfile)

        binding.btnGithub.setOnClickListener {
            openLink(githubUrl)
        }

        binding.btnLinkedin.setOnClickListener {
            openLink(linkedinUrl)
        }

        binding.btnInstagram.setOnClickListener {
            openLink(instagramUrl)
        }

        binding.btnWhatsapp.setOnClickListener {
            openLink(whatsappUrl)
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}