package com.example.zora_shape.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CalculationHistory::class, NewsBookmark::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calculationDao(): CalculationDao
    abstract fun newsBookmarkDao(): NewsBookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "zora_shape_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}