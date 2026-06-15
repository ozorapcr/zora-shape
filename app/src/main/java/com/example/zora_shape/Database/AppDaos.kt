package com.example.zora_shape.Database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CalculationDao {
    @Query("SELECT * FROM calculation_history ORDER BY date DESC")
    fun getAllHistory(): Flow<List<CalculationHistory>>

    @Insert
    suspend fun insert(history: CalculationHistory)

    @Query("DELETE FROM calculation_history")
    suspend fun deleteAll()
}

@Dao
interface NewsBookmarkDao {
    @Query("SELECT * FROM news_bookmark")
    fun getAllBookmarks(): Flow<List<NewsBookmark>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmark: NewsBookmark)

    @Delete
    suspend fun delete(bookmark: NewsBookmark)

    @Query("SELECT EXISTS(SELECT * FROM news_bookmark WHERE url = :url)")
    suspend fun isBookmarked(url: String): Boolean
}