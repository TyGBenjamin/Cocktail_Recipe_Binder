package com.example.cocktails.model.retrofit

import com.example.cocktails.model.remote.ApiService
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * [Retrofit] class for building retrofit [JSON] converter.
 *
 * @constructor Create empty Retrofit class
 */
@OptIn(ExperimentalSerializationApi::class)
object RetrofitClass {
    private const val BASE_URL = "https://www.thecocktaildb.com/api/"
    private const val VERSION ="json/v1/1/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL+ VERSION)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Get api service.
     *
     * @return
     */
    fun getApiService(): ApiService = retrofit.create()
}

