package com.example.composemvvm.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ThirdScreenViewModel
 *
 * ViewModel for the ThirdScreen composable.
 * It uses SavedStateHandle to retrieve navigation arguments passed from the previous screen.
 *
 * This follows the MVVM pattern and uses Hilt for dependency injection.
 *
 * @param savedStateHandle Used to safely access the navigation arguments.
 */
@HiltViewModel
class ThirdScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    /**
     * Argument passed from previous screen via navigation.
     * Replace "argumentKey" with the actual key used in your NavGraph route (e.g., "third_screen/{argumentKey}").
     */
    val argument: String? = savedStateHandle.get<String>("argumentKey")
}
