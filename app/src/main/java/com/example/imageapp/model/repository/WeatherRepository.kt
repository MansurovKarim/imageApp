package com.example.imageapp.model.repository

import com.example.imageapp.model.core.Either
import com.example.imageapp.model.models.WhetherResponse
import com.example.imageapp.model.service.WhetherApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: WhetherApiService
) {
    suspend fun getImages(apiKey: String, query: String): Either<Throwable, WhetherResponse> {
        return try {
            val response = apiService.getWhether(apiKey, query)
            Either.Success(response)
        } catch (e: Exception) {
            Either.Error(e)

        }
    }
}