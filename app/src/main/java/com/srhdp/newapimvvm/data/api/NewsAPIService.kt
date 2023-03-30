package com.srhdp.newapimvvm.data.api

import com.srhdp.newapimvvm.BuildConfig
import com.srhdp.newapimvvm.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadLines(@Query("country")country:String, @Query("page")page:Int, @Query("apiKey")apiKey:String= BuildConfig.API_KEY): Response<APIResponse>

}