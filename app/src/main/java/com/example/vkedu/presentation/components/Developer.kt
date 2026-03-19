package com.example.vkedu.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.vkedu.data.mapper.AppMapper
import com.example.vkedu.data.source.LocalDataSource
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun Developer(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "Разработчик",
                fontSize = 14.sp
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VkEduTheme {
        Developer(
            name = AppMapper.toDomain(LocalDataSource.apps[0]).developer.ifEmpty { "Неизвестно" },
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}