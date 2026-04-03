package com.example.vkedu.data.network.dto

import com.google.gson.annotations.SerializedName

data class CatalogItemDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("developer")
    val developer: String,
    @SerializedName("screenshots")
    val screenshots: List<String>
)