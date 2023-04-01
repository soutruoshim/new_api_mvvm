package com.srhdp.newapimvvm.data.repository.datasource

import com.srhdp.newapimvvm.data.model.APIResponse
import retrofit2.Response

interface NewRemoteDataSource {
    suspend fun getTopHeadLines(country:String, page:Int):Response<APIResponse>
}