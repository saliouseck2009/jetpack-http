package com.example.http_practice.data.datasource

import com.example.http_practice.domain.model.QuotesResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiService {
    @GET("/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>
}