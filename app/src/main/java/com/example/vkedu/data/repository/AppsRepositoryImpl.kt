package com.example.vkedu.data.repository

import com.example.vkedu.data.mapper.AppMapper
import com.example.vkedu.data.source.LocalDataSource
import com.example.vkedu.domain.model.App
import com.example.vkedu.domain.repository.AppsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppsRepositoryImpl @Inject constructor(
    private val mapper: AppMapper
): AppsRepository {
    override fun getApps(): Flow<List<App>> = flow {
        delay(1000)
        val apps = LocalDataSource.apps.map { dto ->
            AppMapper.toDomain(dto)
        }
        emit(apps)
    }
}