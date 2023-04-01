package com.srhdp.newapimvvm.presentation.di

import com.srhdp.newapimvvm.data.api.NewsAPIService
import com.srhdp.newapimvvm.data.repository.datasource.NewsRemoteDataSource
import com.srhdp.newapimvvm.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}
