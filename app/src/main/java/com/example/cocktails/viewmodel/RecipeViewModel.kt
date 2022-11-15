package com.example.cocktails.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.entity.SpecificRecipe
import com.example.cocktails.model.repository.RepositoryImpl
import com.example.cocktails.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Recipe view model.
 *
 * @constructor Create empty Recipe view model
 */
class RecipeViewModel : ViewModel() {
    private val repo = RepositoryImpl
    private val _recipe: MutableStateFlow<Resource<List<SpecificRecipe>>> = MutableStateFlow(
        Resource.Loading
    )
    val recipe = _recipe.asStateFlow()

    /**
     * Get detail recipes.
     *
     * @param list
     */
    fun getDetailRecipe(list: String) {
        Log.d(TAG, "getDetailRecipe called")
        viewModelScope.launch {
            _recipe.value = repo.getDrinkDetailRecipe(list)
            Log.d(TAG, "Recipe Flow State: ${recipe.value}")
        }
    }

    companion object {
        const val TAG = "RecipeViewModelLgr"
    }
}

