package com.example.cocktails.model.repository

import com.example.cocktails.model.dto.DataResponse
import com.example.cocktails.model.dto.DrinkByCategoryDTO
import com.example.cocktails.model.dto.DrinkDTO
import com.example.cocktails.model.dto.DrinkRecipeResponse
import com.example.cocktails.model.dto.SpecificRecipeDTO
import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.entity.SpecificRecipe
import com.example.cocktails.model.mapper.DrinkByCategoryMapper
import com.example.cocktails.model.mapper.DrinkCategoryListMapper
import com.example.cocktails.model.mapper.SpecificRecipeMapper
import com.example.cocktails.model.retrofit.RetrofitClass
import com.example.cocktails.repository.Repository
import com.example.cocktails.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryImpl : Repository {
    private val apiInstance by lazy { RetrofitClass.getApiService() }
    private val mapper = DrinkCategoryListMapper()
    private val mapperByCategory = DrinkByCategoryMapper()
    private val recipeMapper = SpecificRecipeMapper()



    override suspend fun getCategoryList(categoryList: String): Resource<List<Drink>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val res = apiInstance.getCategoryList("list")
                if (res.isSuccessful && res.body() != null) {
                    println(res.body())
                    Resource.Success(res.body()!!.drinks.map { mapper(it) })
                } else {
                    Resource.Error(res.message())
                }

            } catch (e: IllegalAccessError) {
                Resource.Error(e.message.toString())
            }
        }

    override suspend fun getSelectedCategoryDrinks(categoryName: String): Resource<List<DrinkByCategory>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val res = apiInstance.getSelectedCategoryDrinks(categoryName)
                if (res.isSuccessful && res.body() != null) {
                    println(res.body())
                    Resource.Success(res.body()!!.drinks.map { mapperByCategory(it) })
                } else {
                    Resource.Error(res.message())
                }

            } catch (e: IllegalAccessError) {
                Resource.Error(e.message.toString())
            }
        }

        override suspend fun getDrinkDetailRecipe(drinkName: String): Resource<List<SpecificRecipe>> =
            withContext(Dispatchers.IO){
                return@withContext try{
                    val res = apiInstance.getRecipe(drinkName)
                    if (res.isSuccessful && res.body()!=null){
                        println(res.body())
                        Resource.Success(res.body()!!.drinks.map { recipeMapper(it) })
                    } else {
                        Resource.Error(res.message())
                    }
                }

                catch(e: IllegalAccessError){
                    Resource.Error(e.message.toString())
                }
            }


    }
