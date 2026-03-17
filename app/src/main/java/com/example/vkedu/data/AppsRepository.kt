package com.example.vkedu.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppsRepository {

    fun getApps(shouldError: Boolean = false): Flow<List<App>> = flow {
        delay(1000)
        if (shouldError) {
            throw Exception("Не удалось загрузить приложения")
        } else {
            emit(appsList)
        }
    }
}