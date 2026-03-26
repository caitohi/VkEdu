package com.example.vkedu.data.mapper

import com.example.vkedu.data.dto.AppDto
import com.example.vkedu.domain.model.App
import com.example.vkedu.domain.model.Category
import javax.inject.Inject
import javax.inject.Singleton

object AppMapper @Inject constructor() {
    fun toDomain(dto: AppDto): App = App(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = when (dto.category) {
            "FINANCE" -> Category.FINANCE
            "INSTRUMENTS" -> Category.INSTRUMENTS
            "TRANSPORT" -> Category.TRANSPORT
            else -> Category.INSTRUMENTS
        },
        iconRes = dto.iconRes,
        developer = dto.developer,
        screenshotUrls = dto.screenshotUrls
    )
    fun toDomain(dto: CatalogItemDto): App = App(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = when (dto.category.lowercase()) {
            "finance" -> Category.FINANCE
            "instruments" -> Category.INSTRUMENTS
            "transport" -> Category.TRANSPORT
            else -> Category.INSTRUMENTS
        },
        iconRes = 0,
        developer = dto.developer,
        screenshotUrls = dto.screenshots
    )
}