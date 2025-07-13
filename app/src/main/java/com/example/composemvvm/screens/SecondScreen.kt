package com.example.composemvvm.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composemvvm.Routes

/**
 * Second Screen Composable

 * This screen demonstrates how to navigate to another screen (ThirdScreen)
 * while passing arguments via the NavController using route-based navigation.

 * @param navController The NavController used to handle navigation between composables.
 */
@Composable
fun SecondScreen(navController: NavHostController) {

    // Example argument to be passed to the next screen.
    // In real applications, this could come from user input, ViewModel, or network response.
    val argument = "argument-value"

    // Navigate to ThirdScreen with an argument.
    // The route must match the one defined in NavGraph (e.g., "third_screen/{yourArgKey}")
    navController.navigate("${Routes.THIRD_SCREEN}/$argument")
}
