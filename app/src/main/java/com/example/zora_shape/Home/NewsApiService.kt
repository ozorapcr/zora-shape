package com.example.zora_shape.Home

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("category") category: String = "general",
        @Query("lang") lang: String = "id",
        @Query("country") country: String = "id",
        @Query("apikey") apikey: String = "2dc2d63e86f1b930bc89e6deb70a8178"
    ): NewsResponse

    companion object {
        private const val BASE_URL = "https://gnews.io/api/v4/"

        fun create(): NewsApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(NewsApiService::class.java)
        }
    }
}