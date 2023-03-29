package com.srhdp.newapimvvm.domain.usecase

import com.srhdp.newapimvvm.data.model.Article
import com.srhdp.newapimvvm.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute():Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}