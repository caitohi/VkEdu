package com.example.vkedu.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedu.data.mapper.AppMapper
import com.example.vkedu.data.source.LocalDataSource
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppDescription(
    description: String,
    collapsed: Boolean,
    onReadMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = "Описание приложения",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = description,
            maxLines = if (collapsed) Int.MAX_VALUE else 1,
            overflow = TextOverflow.Ellipsis,
        )
        if (!collapsed) {
            TextButton(
                onClick = onReadMoreClick,
                contentPadding = PaddingValues(horizontal = 0.dp)
            ) {
                Text(
                    text = "Читать далее",
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShort() {
    VkEduTheme {
        AppDescription(
            description = AppMapper.toDomain(LocalDataSource.apps[0]).description,
            onReadMoreClick = {},
            collapsed = false,
        )
    }
}