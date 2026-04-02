package com.example.vkedu.data.database.entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class AppEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val developer: String,
    val screenshotUrls: String,
    val isInWishlist: Boolean = false  // ← добавить
)
