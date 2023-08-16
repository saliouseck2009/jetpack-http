package com.example.http_practice.data.repository;

import com.example.http_practice.data.datasource.QuoteApiService;
import com.example.http_practice.utils.Results
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import javax.inject.Inject;


class QuotesRepository @Inject constructor(
        private val api: QuoteApiService
) {
    suspend fun getQuotes() = flow{
            emit(Results.Loading())
            val quotes = api.getQuotes().body()?.quotes
            emit(Results.Success(quotes))
        }.catch {e ->
            emit(Results.Error(e.message ?: "An unexpected error occurred"))
        }




}
