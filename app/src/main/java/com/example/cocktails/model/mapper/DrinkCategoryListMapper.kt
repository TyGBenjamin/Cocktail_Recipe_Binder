package com.example.cocktails.model.mapper

import com.example.cocktails.model.dto.DrinkDTO
import com.example.cocktails.model.entity.Drink


/**
     * Origin mapper for mapping DTO to data class objects.
     *
     * @constructor Create empty Origin mapper
     */
    class DrinkCategoryListMapper : Mapper<DrinkDTO, Drink> {
        override fun invoke(dto: DrinkDTO): Drink {
            return with(dto) {
                Drink(
                    strCategory = strCategory ?: "",
                )
            }
        }
    }
