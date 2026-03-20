package com.example.vkedu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedu.R
import com.example.vkedu.ui.theme.VkEduTheme

@Composable
fun AppTopBar(
    isListView: Boolean,
    onViewToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_rustore_logo),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )

        Text(
            text = "RuStore",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onViewToggle) {
            Icon(
                painter = painterResource(
                    id = if (isListView)
                        R.drawable.ic_baseline_grid_view_24
                    else
                        R.drawable.ic_baseline_list_24
                ),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppTopBar() {
    VkEduTheme {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3F6FEC))
        ) {
            AppTopBar(
                isListView = true,
                onViewToggle = {}
            )
        }
    }
}