package com.srhdp.newapimvvm.presentation.di

import com.srhdp.newapimvvm.data.db.ArticleDAO
import com.srhdp.newapimvvm.data.repository.datasource.NewsLocalDataSource
import com.srhdp.newapimvvm.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(articleDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }

}
