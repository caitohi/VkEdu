package com.example.vkedu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedu.data.App
import com.example.vkedu.data.Category
import com.example.vkedu.data.appsList
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppCard(
    app: App,
    onClick: () -> Unit,
    showDivider: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = app.iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = app.name,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = app.description,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Text(
                    text = when (app.category) {
                        Category.FINANCE -> "Финансы"
                        Category.INSTRUMENTS -> "Инструменты"
                        Category.TRANSPORT -> "Транспорт"
                    },
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        if (showDivider) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(alpha = 0.5f),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppCard() {
    VkEduTheme {
        Column {
            AppCard(
                app = appsList[0],
                onClick = {},
                showDivider = true
            )
            AppCard(
                app = appsList[1],
                onClick = {},
                showDivider = true
            )
            AppCard(
                app = appsList[2],
                onClick = {},
                showDivider = false
            )
        }
    }
}