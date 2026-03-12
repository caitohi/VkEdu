package com.example.vkedu.presentation.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu.data.App
import com.example.vkedu.data.appsList
import com.example.vkedu.presentation.components.AppCard
import com.example.vkedu.presentation.components.AppTopBar
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppsListScreen(
    onAppClick: (App) -> Unit
) {
    val isListView = remember { mutableStateOf(true) }

    Scaffold(
        containerColor = Color(0xFF3F6FEC),
        topBar = {
            AppTopBar(
                isListView = isListView.value,
                onViewToggle = { isListView.value = !isListView.value }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
        ) {
            if (isListView.value) {
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(appsList) { app ->
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
                    items(appsList) { app ->
                        AppCard(
                            app = app,
                            onClick = { onAppClick(app) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppsListScreen() {
    VkEduTheme {
        AppsListScreen(
            onAppClick = {}
        )
    }
}