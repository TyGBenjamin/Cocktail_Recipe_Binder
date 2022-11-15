package com.example.cocktails.repository

import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.entity.SpecificRecipe
import com.example.cocktails.util.Resource

/**
 * Repository Abstract.
 *
 * @constructor Create empty Repository
 */
interface Repository {
    suspend fun getCategoryList(categoryList: String = "list"): Resource<List<Drink>>
    suspend fun getSelectedCategoryDrinks(categoryName: String): Resource<List<DrinkByCategory>>
    suspend fun getDrinkDetailRecipe(drinkName: String): Resource<List<SpecificRecipe>>
}
