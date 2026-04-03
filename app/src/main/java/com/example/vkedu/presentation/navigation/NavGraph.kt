package com.example.vkedu.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vkedu.data.mapper.AppMapper
import com.example.vkedu.data.source.LocalDataSource
import com.example.vkedu.presentation.screens.AppDetailScreen
import com.example.vkedu.presentation.screens.appslist.AppsListScreen
import com.example.vkedu.presentation.screens.appslist.AppsListViewModel

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "apps_list",
        modifier = modifier
    ) {
        composable("apps_list") {
            val viewModel: AppsListViewModel = hiltViewModel()
            AppsListScreen(
                viewModel = viewModel,
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
            val appDto = LocalDataSource.apps.find { it.id == appId } ?: LocalDataSource.apps[0]
            val app = AppMapper().toDomain(appDto)

            AppDetailScreen(
                app = app,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}