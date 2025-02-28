package com.example.imageapp.model.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("hits")
    val hits: List<Hit?>?= null,
    @SerialName ("total")
    val total: Int,
    @SerialName ("totalHits")
    val totalHits: Int
)