package com.example.cocktails.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.navigation.Screens
import com.example.cocktails.viewmodel.RecipeViewModel

@Composable
fun DrinkByCategoryScreen(
    navController: NavController, drinks: List<DrinkByCategory>,
    recipeViewModel: RecipeViewModel = viewModel(),
) {
    Column() {
        LazyColumn(modifier = Modifier.padding(5.dp)) {
            items(items = drinks) { drink ->
                CharCardCategory(
                    drinkByCategory = drink,
                    navigate = {
                        Log.d("RecipeViewModelLgr", "DrinkByCategoryScreen: hey!")
                        println("DrinkByCategoryScreen: hey!")
                        recipeViewModel.getDetailRecipe(drink.strDrink)
                        navController.navigate("recipe_screen/${drink.strDrink}")
                    }
                )
                Button(onClick = { navController.navigate(Screens.Constants.homeScreen) },
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(horizontal = 140.dp)) {
                    Text(text = "Home")
                }
            }
        }
    }
}

