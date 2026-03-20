package com.example.vkedu.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu.domain.model.App
import com.example.vkedu.data.mapper.AppMapper
import com.example.vkedu.data.source.LocalDataSource
import com.example.vkedu.presentation.components.AppDescription
import com.example.vkedu.presentation.components.AppDetailsHeader
import com.example.vkedu.presentation.components.Developer
import com.example.vkedu.presentation.components.InstallButton
import com.example.vkedu.presentation.components.ScreenshotsList
import com.example.vkedu.presentation.components.Toolbar
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppDetailScreen(
    app: App,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit = {},
    onInstallClick: () -> Unit = {},
    onDeveloperClick: () -> Unit = {}
) {
    val descriptionCollapsed = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppDetailsHeader(
            app = app,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        InstallButton(onClick = onInstallClick)

        if (app.screenshotUrls.isNotEmpty()) {
            ScreenshotsList(
                screenshotUrlList = app.screenshotUrls,
                contentPadding = PaddingValues(horizontal = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        AppDescription(
            description = app.description,
            collapsed = descriptionCollapsed.value,
            onReadMoreClick = {
                descriptionCollapsed.value = !descriptionCollapsed.value
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        androidx.compose.material3.HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray.copy(alpha = 0.5f),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Developer(
            name = app.developer.ifBlank { "Неизвестно" },
            onClick = onDeveloperClick,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppDetailScreen() {
    VkEduTheme {
        AppDetailScreen(
            app = AppMapper.toDomain(LocalDataSource.apps[0]),
            onBackClick = {}
        )
    }
}