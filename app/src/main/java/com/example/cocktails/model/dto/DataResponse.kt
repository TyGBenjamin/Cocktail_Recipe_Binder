package com.example.cocktails.model.dto

@kotlinx.serialization.Serializable
data class DataResponse(
    val drinks: List<DrinkDTO>
)
