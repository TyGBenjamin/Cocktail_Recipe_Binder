package com.example.cocktails.model.mapper

import androidx.compose.ui.platform.NoInspectorInfo
import com.example.cocktails.model.dto.DrinkByCategoryDTO
import com.example.cocktails.model.dto.SpecificRecipeDTO
import com.example.cocktails.model.entity.DrinkByCategory
import com.example.cocktails.model.entity.SpecificRecipe
import com.google.gson.annotations.SerializedName

/**
 * Specific Recipe Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Origin mapper
 */
class SpecificRecipeMapper : Mapper<SpecificRecipeDTO, SpecificRecipe> {
    override fun invoke(dto: SpecificRecipeDTO): SpecificRecipe {
        return with(dto) {
            SpecificRecipe(
                dateModified ?: "",
            idDrink ?: "",
            strAlcoholic ?: "",
            strCategory ?: "",
                strCreativeCommonsConfirmed,
            strDrink ?: "",
            strDrinkAlternate ?: "",
            strDrinkThumb ?: "",
            strGlass ?: "",
            strIBA ?: "",
            strImageAttribution ?: "",
            strImageSource ?: "",
            strIngredient1 ?: "",
            strIngredient10 ?: "",
            strIngredient11 ?: "",
            strIngredient12 ?: "",
            strIngredient13 ?: "",
            strIngredient14 ?: "",
            strIngredient15 ?: "",
            strIngredient2 ?: "",
            strIngredient3 ?: "",
            strIngredient4 ?: "",
            strIngredient5 ?: "",
            strIngredient6 ?: "",
            strIngredient7 ?: "",
            strIngredient8 ?: "",
            strIngredient9 ?: "",
            strInstructions ?: "",
            strInstructionsDE ?: "",
            strInstructionsES ?: "",
                strInstructionsFR ?: "",
                strInstructionsIT ?: "",
            strInstructionszhHANS ?: "",
            strInstructionszhHANT ?: "",
            strMeasure1  ?: "",
            strMeasure10 ?: "",
            strMeasure11 ?: "",
            strMeasure12 ?: "",
            strMeasure13 ?: "",
            strMeasure14 ?: "",
            strMeasure15 ?: "",
            strMeasure2 ?: "",
            strMeasure3 ?:"",
            strMeasure4 ?:"",
            strMeasure5 ?:"",
            strMeasure6 ?:"",
            strMeasure7 ?:"",
            strMeasure8 ?:"",
            strMeasure9 ?:"",
            strTags ?:"",
            strVideo ?:"",
            )
        }
    }
}
