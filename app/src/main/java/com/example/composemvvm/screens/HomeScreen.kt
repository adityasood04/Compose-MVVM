package com.example.composemvvm.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composemvvm.utils.UiState
import com.example.composemvvm.viewmodels.HomeViewModel

/**
 * HomeScreen shows how to use UiState (Loading, Success, Error) from the ViewModel.
 * Displays loading indicator, data, or error message.
 */
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: HomeViewModel = hiltViewModel()

    // This is a demo code. Guys please update this with your respective logics here ---------------------------
    val state = viewModel.data.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    // Show snackbar when there's an error
    LaunchedEffect(state.value) {
        if (state.value is UiState.Error) {
            snackbarHostState.showSnackbar(
                message = (state.value as UiState.Error).message,
                withDismissAction = true
            )
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        when (val result = state.value) {
            is UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.Success -> {
                val items = result.data
                Text(
                    text = "Fetched ${items.size} items",
                    modifier = Modifier.padding(paddingValues)
                )
            }

            is UiState.Error -> {
                // UI already handled by snackbar
            }
        }
    }
}
