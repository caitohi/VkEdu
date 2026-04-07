package com.example.vkedu.data.mapper

import com.example.vkedu.data.network.dto.CatalogItemDto
import com.example.vkedu.domain.model.Category
import junit.framework.TestCase.assertEquals
import org.junit.Test

class AppMapperTest {
    private val mapper = AppMapper()

    @Test
    fun `toDomain should map CatalogItemDto correctly`() {
        val dto = CatalogItemDto(
            id = 1,
            name = "Test App",
            description = "Test Description",
            category = "finance",
            iconUrl = "",
            developer = "Test Dev",
            screenshots = emptyList()
        )

        val result = mapper.toDomain(dto)

        assertEquals(1, result.id)
        assertEquals("Test App", result.name)
        assertEquals(Category.FINANCE, result.category)
    }
}