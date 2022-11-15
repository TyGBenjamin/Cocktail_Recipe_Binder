package com.example.cocktails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.repository.RepositoryImpl
import com.example.cocktails.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeForDrinkViewModel: ViewModel() {
    private val repo = RepositoryImpl
    private val _drinkRecipe: MutableStateFlow<Resource<List<DrinkByCategory>>> = MutableStateFlow(
        Resource.Loading)
    val drinkRecipe = _drinkRecipe.asStateFlow()


    fun getDrinkByCategory(list:String = "list"){
        viewModelScope.launch {
            _drinkRecipe.value = repo.getSelectedCategoryDrinks(list)
            println("THIS IS VALUE OF FLOW ${repo.getCategoryList(list)}")
        }
    }
}
