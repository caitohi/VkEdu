package com.example.vkedu.data

enum class Category {
    FINANCE,
    INSTRUMENTS,
    TRANSPORT
}

data class App(
    val id: Int,
    val name: String,
    val description: String,
    val category: Category,
    val iconRes: Int,
    val developer: String = "",
    val screenshotUrls: List<String> = emptyList()
)