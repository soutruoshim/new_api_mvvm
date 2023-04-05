package com.srhdp.newapimvvm.domain.repository

import com.srhdp.newapimvvm.data.model.APIResponse
import com.srhdp.newapimvvm.data.model.Article
import com.srhdp.newapimvvm.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
   suspend fun getNewsHeadlines(country:String, page:Int):Resource<APIResponse>
   suspend fun getSearchedNews(country: String, searchQuery:String, page: Int):Resource<APIResponse>
   suspend fun saveNews(article: Article)
   suspend fun deleteNews(article: Article)
   fun getSavedNews(): Flow<List<Article>>
}