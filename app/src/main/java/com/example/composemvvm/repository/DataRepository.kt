package com.example.composemvvm.repository

import com.example.composemvvm.api.ApiService
import com.example.composemvvm.models.Item
import com.example.composemvvm.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * DataRepository handles API calls and exposes UiState to the ViewModel.
 * Emits Loading, Success, or Error states to help UI render appropriate content.
 */
class DataRepository @Inject constructor(
    private val apiService: ApiService
) {
    private val _data = MutableStateFlow<UiState<List<Item>>>(UiState.Loading)

    // Expose state as read-only to ViewModel
    val data: StateFlow<UiState<List<Item>>> get() = _data

    /**
     * Fetches data from API and emits appropriate UiState based on result.
     */
    suspend fun getData(param: String) {
        _data.emit(UiState.Loading)
        try {
            val response = apiService.getData(param)
            if (response.isSuccessful && response.body() != null) {
                _data.emit(UiState.Success(response.body()!!))
            } else {
                _data.emit(UiState.Error("Error Code: ${response.code()}"))
            }
        } catch (e: Exception) {
            _data.emit(UiState.Error("Exception: ${e.localizedMessage ?: "Unknown error"}"))
        }
    }
}
