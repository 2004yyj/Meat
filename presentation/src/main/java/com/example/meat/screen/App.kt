package com.example.meat.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                            appState.replaceToDetail(it, navBackStackEntry)
                        }
                    )
                }

                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(
                        navArgument("key") {
                            type = NavType.StringType
                        },
                        navArgument("name") {
                            type = NavType.StringType
                        },
                        navArgument("price") {
                            type = NavType.IntType
                        }
                    )
                ) { navBackStackEntry ->
                    navBackStackEntry.arguments?.apply {
                        val key = getString("key")
                        val name = getString("name")
                        val price = getInt("price")
                        Detail(
                            key = key!!,
                            name = name!!,
                            price = price,
                            onNavigationClick = {
                                appState.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}