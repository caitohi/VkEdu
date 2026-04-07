package com.example.vkedu.data.repository

import com.example.vkedu.data.mapper.AppMapper
import com.example.vkedu.data.network.api.CatalogApi
import com.example.vkedu.data.network.dto.CatalogResponseDto
import com.example.vkedu.data.source.LocalDataSource
import com.example.vkedu.domain.repository.AppsRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class AppsRepositoryImplTest {

    private val api = mock(CatalogApi::class.java)
    private val mapper = AppMapper()

    private val repository: AppsRepository = AppsRepositoryImpl(api, mapper)

    @Test
    fun `getApps should return list of apps from api`() = runTest {
        val mockResponse = CatalogResponseDto(listOf())
        `when`(api.getCatalog()).thenReturn(mockResponse)

        val result = repository.getApps().collectList()

        assert(result.isNotEmpty())
    }
}