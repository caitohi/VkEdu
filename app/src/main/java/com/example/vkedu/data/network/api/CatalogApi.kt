package com.example.vkedu.data.network.api

import com.example.vkedu.data.network.dto.CatalogResponseDto
import retrofit2.http.GET

interface CatalogApi {
    @GET("catalog")
    suspend fun getCatalog(): CatalogResponseDto
}