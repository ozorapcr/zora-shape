package com.example.zora_shape.Home

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val totalArticles: Int,
    val articles: List<NewsPost>
)

data class NewsPost(
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    @SerializedName("publishedAt")
    val publishedAt: String
)