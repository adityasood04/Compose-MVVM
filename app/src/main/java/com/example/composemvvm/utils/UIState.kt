package com.example.composemvvm.utils

/**
 * Represents different UI states for data operations.
 * Helps screens display loading, success, or error states in a type-safe way.
 */
sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
