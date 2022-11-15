package com.example.cocktails.util

/**
 * Resource.
 *
 * @param T
 * @constructor Create empty Resource
 */
sealed class Resource<out T> {
    /**
     * Success
     *
     * @param T
     * @property data
     * @constructor Create empty Success
     */
    data class Success<T>(val data: T) : Resource<T>()

    /**
     * Loading
     *
     * @constructor Create empty Loading
     */
    object Loading : Resource<Nothing>()
    data class Error(val message: String) : Resource<Nothing>()
}
