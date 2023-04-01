package com.srhdp.newapimvvm.data.repository.datasourceimpl

import com.srhdp.newapimvvm.data.api.NewsAPIService
import com.srhdp.newapimvvm.data.model.APIResponse
import com.srhdp.newapimvvm.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newApiService: NewsAPIService
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newApiService.getTopHeadLines(country, page)
    }
}