package com.example.vkedu.data.database.converter

import androidx.core.animation.TypeConverter
import androidx.room.TypeConverter
import com.example.vkedu.domain.model.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}