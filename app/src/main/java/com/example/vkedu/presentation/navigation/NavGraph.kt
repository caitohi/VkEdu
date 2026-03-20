package com.example.vkedu.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vkedu.data.appsList
import com.example.vkedu.presentation.screens.AppDetailScreen
import com.example.vkedu.presentation.screens.AppsListScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "apps_list",
        modifier = modifier
    ) {
        composable("apps_list") {
            AppsListScreen(
                onAppClick = { app ->
                    navController.navigate("app_detail/${app.id}")
                }
            )
        }

        composable(
            route = "app_detail/{appId}",
            arguments = listOf(navArgument("appId") { type = NavType.IntType })
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getInt("appId") ?: 0
            val app = appsList.find { it.id == appId } ?: appsList[0]

            AppDetailScreen(
                app = app,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}