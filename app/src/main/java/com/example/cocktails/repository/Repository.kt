package com.example.cocktails.repository

import com.example.cocktails.model.dto.DataResponse
import com.example.cocktails.model.dto.DrinkByCategoryDTO
import com.example.cocktails.model.dto.DrinkDTO
import com.example.cocktails.model.dto.DrinkRecipeResponse
import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.entity.SpecificRecipe
import com.example.cocktails.model.remote.ApiService
import com.example.cocktails.util.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Repository {
    suspend fun getCategoryList(categoryList: String = "list"): Resource<List<Drink>>
    suspend fun getSelectedCategoryDrinks(categoryName: String): Resource<List<DrinkByCategory>>
    suspend fun getDrinkDetailRecipe(drinkName: String): Resource<List<SpecificRecipe>>
}
