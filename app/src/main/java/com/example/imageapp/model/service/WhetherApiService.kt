package com.example.imageapp.model.service

import com.example.imageapp.model.models.WhetherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WhetherApiService {
    @GET("https://api.weatherapi.com/v1/current.json")
    suspend fun getWhether(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): WhetherResponse
}