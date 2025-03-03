package com.example.imageapp.model.repository

import com.example.imageapp.model.core.Either
import com.example.imageapp.model.models.ApiResponse
import com.example.imageapp.model.service.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getImages(apiKey: String, query: String): Either<Throwable, ApiResponse> {
        return try {
            val response = apiService.getImages(apiKey, query)
            Either.Success(response)
        } catch (e: Exception) {
            Either.Error(e)
        }
    }
}
