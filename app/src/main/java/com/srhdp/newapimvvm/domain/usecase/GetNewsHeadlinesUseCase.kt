package com.srhdp.newapimvvm.domain.usecase

import com.srhdp.newapimvvm.data.model.APIResponse
import com.srhdp.newapimvvm.data.util.Resource
import com.srhdp.newapimvvm.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines()
    }
}