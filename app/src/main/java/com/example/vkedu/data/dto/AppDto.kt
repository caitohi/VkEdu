package com.example.vkedu.data.dto

data class AppDto(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val iconRes: Int,
    val developer: String = "",
    val screenshotUrls: List<String> = emptyList()
)