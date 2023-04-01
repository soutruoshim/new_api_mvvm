package com.srhdp.newapimvvm.data.repository.datasourceimpl

import com.srhdp.newapimvvm.data.api.NewsAPIService
import com.srhdp.newapimvvm.data.model.APIResponse
import com.srhdp.newapimvvm.data.repository.datasource.NewRemoteDataSource
import retrofit2.Response

class NewRemoteDataSourceImpl(
    private val newApiService: NewsAPIService
) : NewRemoteDataSource {
    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newApiService.getTopHeadLines(country, page)
    }
}