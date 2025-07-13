package com.example.composemvvm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composemvvm.viewmodels.ThirdScreenViewModel

/**
 * ThirdScreen
 *
 * This screen demonstrates how to:
 * - Access navigation arguments using ViewModel and SavedStateHandle
 * - Insert and display data from Room DB using Flow
 */
@Composable
fun ThirdScreen(navController: NavHostController) {

    val viewModel: ThirdScreenViewModel = hiltViewModel()
    val items by viewModel.items.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display the argument passed from previous screen (e.g. "argumentKey")
        Text("Received argument: ${viewModel.argument ?: "none"}")

        Spacer(modifier = Modifier.height(16.dp))

        /**
        - Dummy code for Room DB usage.
        - Button to insert a dummy record into Room DB

        Button(onClick = { viewModel.insertDummyItem() }) {
            Text("Insert Dummy Item")
        }

        Spacer(modifier = Modifier.height(16.dp))

        - Display data fetched from Room DB
        - This is just a dummy code. You guys can update this with your logics

        Text("Room Data:", style = MaterialTheme.typography.titleMedium)
        LazyColumn {
            items(items) { item ->
                Text("• ${item.name}: ${item.description}")
            }
        }
         *
         */
    }
}
