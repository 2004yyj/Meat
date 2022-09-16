package com.example.meat.screen

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("detail/{name}") {
        fun createDetail(name: String) = "detail/$name"
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    AppState(navController)
}

class AppState(
    val navController: NavHostController
) {
    fun replaceToDetail(name: String, from: NavBackStackEntry) {
        if (from.isLifecycleResumed()) {
            val encodedUri = Uri.encode(name)
            navController.navigate(Screen.Detail.createDetail(encodedUri))
        }
    }

    fun popBackStack() {
        navController.popBackStack()
    }

}

/**
 * 내비게이션 시 화면이 여러번 보여지는 것을 방지하기 위해
 * 라이프사이클 상태가 RESUME 인지 확인하는 코드를 추가함
 */
private fun NavBackStackEntry.isLifecycleResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED