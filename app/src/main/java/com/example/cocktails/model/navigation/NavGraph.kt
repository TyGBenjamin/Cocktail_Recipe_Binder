package com.example.cocktails.model.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.util.Resource
import com.example.cocktails.view.DrinkByCategoryScreen
import com.example.cocktails.view.ErrorIndicator
import com.example.cocktails.view.HomeScreen
import com.example.cocktails.view.ProgressIndicator
import com.example.cocktails.view.RecipeCard
import com.example.cocktails.view.RecipeList
import com.example.cocktails.viewmodel.DrinkByCategoryViewModel
import com.example.cocktails.viewmodel.RecipeViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(list: List<Drink>) {
    val viewModel: DrinkByCategoryViewModel = viewModel()
    val recipeViewModel: RecipeViewModel = viewModel()
    viewModel.getDrinkByCategory(list[0].strCategory)


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Constants.homeScreen) {
        composable(Screens.Constants.homeScreen) {
            HomeScreen(drinks = list, navController = navController)
        }
//
        composable(Screens.Constants.drinkScreen) {
            val drinkList = viewModel.drinkList.collectAsState().value
            when (drinkList) {
                is Resource.Error -> ErrorIndicator()
                Resource.Loading -> ProgressIndicator()
                is Resource.Success -> DrinkByCategoryScreen(
                    navController = navController,
                    drinks = drinkList.data
                )
            }
        }
//        "profile/{userId}",
//        arguments = listOf(navArgument("userId") { type = NavType.StringType })
        composable(
            Screens.Constants.recipeScreen,
            arguments = listOf(navArgument("drinkString") {
                type = NavType.StringType
            })
        ) { backStack ->
            val recipeList = recipeViewModel.recipe.collectAsState().value
            println("THIS IS WHERE $recipeList IS")
//            when (recipeList) {
//                is Resource.Error -> ErrorIndicator()
//                Resource.Loading -> ProgressIndicator()
//                is Resource.Success -> RecipeList(
//                    recipes = recipeList.data,
//                    navigate = {
//                        navController.navigate(Screens.Constants.homeScreen)
//                    },
//                    strDrink = backStack.arguments?.getString("drinkString")!!,
//                    viewModel = recipeViewModel
//                )
//            }
            RecipeList(
                recipes = listOf(),
                navigate = {
                    navController.navigate(Screens.Constants.homeScreen)
                },
                strDrink = backStack.arguments?.getString("drinkString")!!,
                viewModel = recipeViewModel
            )
        }
    }
}

