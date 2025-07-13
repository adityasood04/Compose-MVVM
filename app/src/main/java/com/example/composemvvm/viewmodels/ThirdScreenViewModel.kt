package com.example.composemvvm.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemvvm.data.local.entities.ItemEntity
import com.example.composemvvm.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for ThirdScreen: handles Room operations.
 */
@HiltViewModel
class ThirdScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val roomRepository: RoomRepository
) : ViewModel() {

    val argument: String? = savedStateHandle["argumentKey"]

    // Observe Room data
    val items = roomRepository.getAllItems()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun insertDummyItem() {
        viewModelScope.launch {
            roomRepository.insertItem(
                ItemEntity(
                    name = "Room Title",
                    description = "Room Desc for $argument"
                )
            )
        }
    }
}
