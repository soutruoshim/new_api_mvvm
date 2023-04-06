package com.srhdp.newapimvvm.presentation.di

import com.srhdp.newapimvvm.data.repository.NewsRepositoryImpl
import com.srhdp.newapimvvm.data.repository.datasource.NewsLocalDataSource
import com.srhdp.newapimvvm.data.repository.datasource.NewsRemoteDataSource
import com.srhdp.newapimvvm.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(
            newsRemoteDataSource,
            newsLocalDataSource
        )
    }

}
