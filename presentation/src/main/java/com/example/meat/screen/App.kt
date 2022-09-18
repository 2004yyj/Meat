package com.example.meat.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.meat.screen.detail.Detail
import com.example.meat.screen.home.Home
import com.example.meat.ui.theme.MeatTheme

@Composable
fun App(
    appState: AppState = rememberAppState()
) {
    MeatTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = appState.navController,
                startDestination = Screen.Home.route
            ) {
                composable(
                    route = Screen.Home.route
                ) { navBackStackEntry ->
                    Home(
                        navigateToDetail = {
                        }
                    )
                }

                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(
                        navArgument("name") {
                            type = NavType.StringType
                        }
                    )
                ) {
                    Detail()
                }
            }
        }
    }
}