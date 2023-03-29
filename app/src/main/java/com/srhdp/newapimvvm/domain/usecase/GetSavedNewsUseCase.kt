package com.srhdp.newapimvvm.domain.usecase

import com.srhdp.newapimvvm.data.model.Article
import com.srhdp.newapimvvm.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}