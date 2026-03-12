package com.example.vkedu.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu.R
import com.example.vkedu.data.App
import com.example.vkedu.data.appsList
import com.example.vkedu.presentation.components.DetailDescription
import com.example.vkedu.presentation.components.DetailHeader
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppDetailScreen(
    app: App,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                tint = Color.Black
            )
        }

        DetailHeader(app = app)

        Spacer(modifier = Modifier.height(24.dp))

        DetailDescription(description = app.description)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppDetailScreen() {
    VkEduTheme {
        AppDetailScreen(
            app = appsList[0],
            onBackClick = {}
        )
    }
}