package com.example.cocktails.model.navigation

sealed class Screens(val route: String){
    object DrinkByCategoryScreen: Screens("?c=Ordinary_Drink"){
        fun passClicked (drink:String) : String {
            return "?c=$drink"
        }
    }
    object Constants{
        const val homeScreen: String = "home_screen"
        const val drinkScreen: String = "drink_screen"
        const val recipeScreen: String = "recipe_screen/{drinkString}"
        const val charLocation: String = "location/{id}"
    }
}
