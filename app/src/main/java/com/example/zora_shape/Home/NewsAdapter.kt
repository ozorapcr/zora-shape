package com.example.zora_shape.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zora_shape.databinding.ItemNewsBinding

class NewsAdapter(private var newsList: List<NewsPost>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.binding.tvNewsTitle.text = news.title
        holder.binding.tvNewsDesc.text = news.description
        
        Glide.with(holder.itemView.context)
            .load(news.image)
            .into(holder.binding.imgNews)
    }

    override fun getItemCount(): Int = newsList.size

    fun setData(newList: List<NewsPost>) {
        newsList = newList
        notifyDataSetChanged()
    }
}