package com.example.cocktails.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cocktails.model.navigation.NavGraph
import com.example.cocktails.ui.theme.CocktailsTheme
import com.example.cocktails.util.Resource
import com.example.cocktails.viewmodel.CategoryListViewModel

class MainActivity : ComponentActivity() {
    private val categoryViewModel: CategoryListViewModel =  CategoryListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailsTheme {
                val viewState = categoryViewModel.categoryList.collectAsState().value
                println(viewState)
                when(viewState){
                    is Resource.Error -> {println("Hitting This error block")
                        }
                    Resource.Loading -> ProgressIndicator()
                    is Resource.Success -> NavGraph(list = viewState.data)
                }
            }
        }
    }
}
