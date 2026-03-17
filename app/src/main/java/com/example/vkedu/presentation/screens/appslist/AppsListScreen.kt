package com.example.vkedu.presentation.screens.appslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.vkedu.data.App
import com.example.vkedu.presentation.components.AppCard
import com.example.vkedu.presentation.components.AppTopBar

@Composable
fun AppsListScreen(
    viewModel: AppsListViewModel,
    onAppClick: (App) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.event) {
        viewModel.event.collect { event ->
            when (event) {
                is AppsListEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        containerColor = Color(0xFF3F6FEC),
        topBar = {
            when (val currentState = state) {
                is AppsListState.Success -> {
                    AppTopBar(
                        isListView = currentState.isListView,
                        onViewToggle = { viewModel.toggleView() },
                        onLogoClick = { viewModel.onLogoClick() }
                    )
                }
                else -> {
                    // Можно показать заглушку
                }
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
        ) {
            when (state) {
                is AppsListState.Loading -> {
                    // Можно добавить прогресс
                }
                is AppsListState.Success -> {
                    val successState = state as AppsListState.Success
                    if (successState.isListView) {
                        LazyColumn(
                            contentPadding = PaddingValues(vertical = 8.dp)
                        ) {
                            items(successState.apps) { app ->
                                AppCard(
                                    app = app,
                                    onClick = { onAppClick(app) }
                                )
                            }
                        }
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            items(successState.apps) { app ->
                                AppCard(
                                    app = app,
                                    onClick = { onAppClick(app) }
                                )
                            }
                        }
                    }
                }
                is AppsListState.Error -> {
                    // Показать ошибку
                }
            }
        }
    }
}