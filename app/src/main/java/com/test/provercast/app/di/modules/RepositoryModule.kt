package com.test.provercast.app.di.modules

import com.test.provercast.repository.Repository
import com.test.provercast.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(repository: RepositoryImpl) : Repository = repository

    @Singleton
    @Provides
    fun provideRepositoryImpl() = RepositoryImpl()
}