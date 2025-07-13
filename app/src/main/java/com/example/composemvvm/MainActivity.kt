package com.example.composemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composemvvm.screens.HomeScreen
import com.example.composemvvm.screens.SecondScreen
import com.example.composemvvm.screens.ThirdScreen
import com.example.composemvvm.ui.theme.ComposeMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity
 *
 * The entry point of the application.
 * Sets up the composable UI and initializes the navigation graph.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMVVMTheme {
                App() // Entry to the composable application
            }
        }
    }
}

/**
 * App
 *
 * Sets up the Navigation Host and defines all routes/screens in the app.
 * Uses NavController to navigate between composables with optional arguments.
 */
@Composable
fun App() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME_SCREEN
    ) {

        // Home screen - initial screen of the app
        composable(route = Routes.HOME_SCREEN) {
            HomeScreen(navController)
        }

        // Second screen - demonstrates passing an argument to another screen
        composable(route = Routes.SECOND_SCREEN) {
            SecondScreen(navController)
        }

        // Third screen - argument received via navigation and accessed in ViewModel using SavedStateHandle
        composable(
            route = "${Routes.THIRD_SCREEN}/{argumentKey}",
            arguments = listOf(
                navArgument(name = "argumentKey") {
                    type = NavType.StringType
                }
            )
        ) {
            ThirdScreen(navController)
        }
    }
}
