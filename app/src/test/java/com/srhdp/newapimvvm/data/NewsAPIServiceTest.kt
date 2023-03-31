package com.srhdp.newapimvvm.data

import com.google.common.truth.Truth.assertThat
import com.srhdp.newapimvvm.data.api.NewsAPIService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {
    private lateinit var service:NewsAPIService
    private lateinit var server:MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(fileName:String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }
    @Test
    fun getTopHeadLines_sentRequest_receivedExpected(){
         runBlocking {
             enqueueMockResponse("newsresponse.json")
             val responseBody = service.getTopHeadLines("us", 1).body()
             val request = server.takeRequest()
             assertThat(responseBody).isNotNull()
             assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=e5eeb5ab26c44f85865f0bcf84cb374e")
         }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines( "us", 1).body()
            val articlesList = responseBody!!.articles
            assertThat(articlesList.size).isEqualTo(20)

        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines( "us", 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("David Marino-Nachison, Paul Hannon, Caitlin McCabe, Chelsey Dulaney, Matthew Thomas, Rebecca Feng")
            assertThat(article.url).isEqualTo("https://www.wsj.com/livecoverage/stock-market-news-today-03-30-2023")
            assertThat(article.publishedAt).isEqualTo("2023-03-30T12:28:00Z")

        }
    }

    @After
    fun tearDown() {
       server.shutdown()
    }
}