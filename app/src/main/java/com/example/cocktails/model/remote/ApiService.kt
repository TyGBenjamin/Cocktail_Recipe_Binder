package com.example.cocktails.model.remote

import com.example.cocktails.model.dto.DataResponse
import com.example.cocktails.model.dto.DrinkByCategoryDTO
import com.example.cocktails.model.dto.DrinkByCategoryResponse
import com.example.cocktails.model.dto.DrinkDTO
import com.example.cocktails.model.dto.DrinkRecipeResponse
import com.example.cocktails.model.dto.SpecificRecipeDTO
import com.example.cocktails.model.entity.SpecificRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(LIST_ENDPOINT)
    suspend fun getCategoryList(@Query("c") list: String="list"): Response<DataResponse>

    @GET(DRINK_IN_CATEGORY)
    suspend fun getSelectedCategoryDrinks(@Query("c") filter:String): Response<DrinkByCategoryResponse>

    @GET(RECIPE_ENDPOINT)
    suspend fun getRecipe(@Query("s") search:String): Response<DrinkRecipeResponse>



    companion object {
        private const val LIST_ENDPOINT = "list.php"
        private const val DRINK_IN_CATEGORY = "filter.php"
        private const val RECIPE_ENDPOINT = "search.php"
    }

}
