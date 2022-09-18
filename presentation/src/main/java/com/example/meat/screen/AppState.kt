package com.example.meat.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meat.domain.model.Product

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("detail/{key}?name={name}?price={price}") {
        fun createDetail(
            product: Product
        ) = "detail/${product.key}?name=${product.name}?price=${product.price}"
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
    fun replaceToDetail(product: Product, from: NavBackStackEntry) {
        if (from.isLifecycleResumed()) {
            navController.navigate(Screen.Detail.createDetail(product))
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