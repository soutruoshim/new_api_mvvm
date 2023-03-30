package com.srhdp.newapimvvm.data.repository.datasourceimpl

import com.srhdp.newapimvvm.data.api.NewsAPIService
import com.srhdp.newapimvvm.data.model.APIResponse
import com.srhdp.newapimvvm.data.repository.datasource.NewRemoteDataSource
import retrofit2.Response

class NewRemoteDataSourceImpl(private val newApiService:NewsAPIService, private val country:String, private val page:Int):NewRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<APIResponse> {
       return newApiService.getTopHeadLines(country, page)
    }
}