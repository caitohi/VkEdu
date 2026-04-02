package com.example.vkedu.domain.repository

import com.example.vkedu.domain.model.App
import kotlinx.coroutines.flow.Flow
interface AppsRepository {
    fun getApps(): Flow<List<App>>
}