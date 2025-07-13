package com.example.composemvvm.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemvvm.models.Item
import com.example.composemvvm.repository.DataRepository
import com.example.composemvvm.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * HomeViewModel connects Repository to UI.
 * Uses StateFlow to expose loading/success/error states via UiState.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Observed in UI using collectAsState()
    val data: StateFlow<UiState<List<Item>>> get() = dataRepository.data

    init {
        viewModelScope.launch {
            val param = savedStateHandle.get<String>("<param-name>") ?: "<default-value>"
            dataRepository.getData(param)
        }
    }
}
