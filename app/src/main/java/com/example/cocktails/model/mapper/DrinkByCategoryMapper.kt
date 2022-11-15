package com.example.cocktails.model.mapper

import com.example.cocktails.model.dto.DrinkByCategoryDTO
import com.example.cocktails.model.dto.DrinkDTO
import com.example.cocktails.model.entity.Drink
import com.example.cocktails.model.entity.DrinkByCategory


/**
 * Origin mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Origin mapper
 */
class DrinkByCategoryMapper : Mapper<DrinkByCategoryDTO, DrinkByCategory> {
    override fun invoke(dto: DrinkByCategoryDTO): DrinkByCategory {
        return with(dto) {
            DrinkByCategory(
                idDrink = idDrink ?: "",
                strDrink = strDrink,
                strDrinkThumb = strDrinkThumb
            )
        }
    }
}
