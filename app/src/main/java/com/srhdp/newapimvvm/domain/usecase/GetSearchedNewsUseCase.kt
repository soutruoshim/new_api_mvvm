package com.srhdp.newapimvvm.domain.usecase

import com.srhdp.newapimvvm.data.model.APIResponse
import com.srhdp.newapimvvm.data.util.Resource
import com.srhdp.newapimvvm.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery:String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}