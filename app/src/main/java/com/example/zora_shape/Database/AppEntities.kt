package com.example.zora_shape.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calculation_history")
data class CalculationHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val input: String,
    val result: String,
    val date: Long = System.currentTimeMillis()
)

@Entity(tableName = "news_bookmark")
data class NewsBookmark(
    @PrimaryKey val url: String,
    val title: String,
    val description: String,
    val image: String,
    val publishedAt: String
)