package com.example.cocktails.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.navigation.Screens
import com.example.cocktails.util.Constants
import com.example.cocktails.util.Resource
import com.example.cocktails.viewmodel.CategoryListViewModel
import com.example.cocktails.viewmodel.DrinkByCategoryViewModel
import com.example.cocktails.viewmodel.RecipeViewModel

@Composable
fun HomeScreen(
    viewModel: CategoryListViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController, drinks: List<Drink>
) {
    when (viewModel.categoryList.collectAsState().value) {
        is Resource.Error -> ErrorIndicator()
        Resource.Loading -> ProgressIndicator()
        is Resource.Success -> LazyColumn(modifier = Modifier.padding(5.dp)) {
            items(items = drinks) { drink ->
                CharCard(
                    drink = drink,
                    navigate = { navController.navigate(Screens.Constants.drinkScreen) },
                )
            }
        }
    }
}

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "ERROR IS RETRIEVING DATA", fontSize = 40.sp)
    }
}

@Composable
fun CharCard(
    drink: Drink,
    drinkByCategory: DrinkByCategory = DrinkByCategory(
        idDrink = "000",
        strDrink = "",
        strDrinkThumb = ""
    ),
    navigate: () -> Unit,
    viewModel: DrinkByCategoryViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Black)
        .clickable {
            println(drink.strCategory)
            viewModel.getDrinkByCategory(drink.strCategory)
            navigate()
            println("Card has been CLICKED")
        }
        .padding(5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp, start = 10.dp
                )
        ) {
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                Text(text = drink.strCategory)
                Image(
                    painter = rememberAsyncImagePainter(Constants.mainImg + Constants.mainImg2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(145.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                )


            }
        }
    }

}

@Composable
fun CharCardCategory(
    drinkByCategory: DrinkByCategory,
    navigate: () -> Unit,
    viewModel: RecipeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Black)
        .clickable {
            println("Card has been   HERE ON NEW PAGE CLICKED")
            navigate()
        }
        .padding(5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp, start = 10.dp
                )
        ) {
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                Text(text = drinkByCategory.strDrink)
                Text(text = "THIS DRINK IS ${drinkByCategory.strDrink}")
                Image(
                    painter = rememberAsyncImagePainter(drinkByCategory.strDrinkThumb),
                    contentDescription = "",
                    modifier = Modifier.size(150.dp)
                )
            }
        }
    }

}
