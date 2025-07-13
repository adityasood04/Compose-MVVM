package com.example.composemvvm.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composemvvm.viewmodels.ThirdScreenViewModel

/**
 * Third Screen Composable
 *
 * This screen demonstrates how to access ViewModel and retrieve arguments using SavedStateHandle,
 * following best practices using MVVM architecture and Hilt for dependency injection.
 *
 * @param navController NavHostController to allow navigation between screens.
 */

@Composable
fun ThirdScreen(navController: NavHostController) {

    // ViewModel injected using Hilt. No need to pass arguments manually.
    val viewModel: ThirdScreenViewModel = hiltViewModel()

    // Access the argument from ViewModel (which uses SavedStateHandle internally)
    Log.d("Aditya", "Argument = ${viewModel.argument}")

    // TODO: Replace with actual UI implementation
    // This is a placeholder for screen UI that will eventually use the ViewModel data
}