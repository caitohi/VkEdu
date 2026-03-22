package com.example.vkedu.di

import com.example.vkedu.data.repository.AppsRepositoryImpl
import com.example.vkedu.domain.repository.AppsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppsRepository(
        impl: AppsRepositoryImpl
    ): AppsRepository
}