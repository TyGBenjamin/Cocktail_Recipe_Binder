package com.example.cocktails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.repository.RepositoryImpl
import com.example.cocktails.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoryListViewModel: ViewModel() {
    private val repo = RepositoryImpl
    private val _categoryList: MutableStateFlow<Resource<List<Drink>>> = MutableStateFlow(Resource.Loading)
    val categoryList = _categoryList.asStateFlow()

    init {
        getCategoryList(list ="list")
    }

    fun getCategoryList(list:String = "list"){
        viewModelScope.launch {
            _categoryList.value = repo.getCategoryList(list)
            println("THIS IS VALUE OF FLOW ${repo.getCategoryList(list)}")
        }
    }
}
