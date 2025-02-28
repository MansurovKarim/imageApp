package com.example.imageapp.model.service

import com.example.imageapp.model.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    suspend fun getImages(
        @Query("key") apiKey: String,
        @Query("q") query: String,

    ): ApiResponse

}