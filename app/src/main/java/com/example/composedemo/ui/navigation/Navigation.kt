package com.example.composedemo.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.ui.home.HomeScreen
import com.example.composedemo.ui.city.CityScreen
import com.example.composedemo.ui.detail.DetailScreen
import com.example.composedemo.ui.settings.SettingsScreen
import androidx.compose.ui.Modifier

object Routes {
    const val HOME = "home"
    const val CITY = "city"
    const val DETAIL = "detail"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Routes.HOME, modifier = modifier) {
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.CITY) { CityScreen() }
        composable(Routes.DETAIL) { DetailScreen() }
        composable(Routes.SETTINGS) { SettingsScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Routes.HOME to "首页",
        Routes.CITY to "城市",
        Routes.DETAIL to "详情",
        Routes.SETTINGS to "设置"
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { (route, label) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = { Text(label) },
                icon = { /* 可放置Icon */ }
            )
        }
    }
} 