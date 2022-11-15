package com.example.cocktails.model.dto

/**
 * Drink recipe response.
 *
 * @property drinks
 * @constructor Create empty Drink recipe response
 */
data class DrinkRecipeResponse(
    val drinks: List<SpecificRecipeDTO>
)
