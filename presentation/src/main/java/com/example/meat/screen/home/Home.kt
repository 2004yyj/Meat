package com.example.meat.screen.home

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.meat.domain.model.Product
import com.example.meat.drawable.DrawableResources
import com.example.meat.screen.home.favorite.Favorite
import com.example.meat.screen.home.list.List

sealed class HomeScreen(val route: String, val drawable: DrawableResources) {
    object ListScreen: HomeScreen("list", DrawableResources.List)
    object FavoriteScreen: HomeScreen("favorite", DrawableResources.OutlinedHeart)

    companion object {
        fun values(): List<HomeScreen> {
            return listOf(
                ListScreen, FavoriteScreen
            )
        }
    }
}

@Composable
fun Home(
    navigateToDetail: (Product) -> Unit,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                HomeScreen.values().forEach { screen ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = screen.drawable.id),
                                contentDescription = "itemIcon"
                            )
                        },
                        label = { Text(screen.route) }
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeScreen.ListScreen.route
        ) {
            composable(HomeScreen.ListScreen.route) {
                List(onClickProduct = navigateToDetail)
            }
            composable(HomeScreen.FavoriteScreen.route) {
                Favorite(onClickProduct = navigateToDetail)
            }
        }
    }
}