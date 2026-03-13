package com.example.vkedu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedu.data.App
import com.example.vkedu.data.Category
import com.example.vkedu.data.appsList
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppDetailsHeader(
    app: App,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = app.iconRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = getCategoryText(app.category),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = app.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = app.developer.ifBlank { "Неизвестно" },
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Row {
                Column(Modifier.width(IntrinsicSize.Max)) {
                    Text(
                        text = "12+",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(text = "Возраст", fontSize = 10.sp, color = Color.Gray)
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(text = "223 MB")
                    Spacer(Modifier.height(4.dp))
                    Text(text = "Размер", fontSize = 10.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
private fun getCategoryText(category: Category): String = when (category) {
    Category.FINANCE -> "Финансы"
    Category.INSTRUMENTS -> "Инструменты"
    Category.TRANSPORT -> "Транспорт"
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VkEduTheme {
        AppDetailsHeader(
            app = appsList[0],
            modifier = Modifier.fillMaxWidth(),
        )
    }
}