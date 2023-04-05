package com.srhdp.newapimvvm.data.repository.datasource

import com.srhdp.newapimvvm.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(country:String, page:Int):Response<APIResponse>
    suspend fun getSearchedNews(country : String,searchQuery:String, page : Int):Response<APIResponse>

}