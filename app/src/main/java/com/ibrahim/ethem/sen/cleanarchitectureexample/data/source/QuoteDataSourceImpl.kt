package com.ibrahim.ethem.sen.cleanarchitectureexample.data.source

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.api.QuoteApi
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.QuoteResult
import javax.inject.Inject

class QuoteDataSourceImpl @Inject constructor(
    private val quoteApi: QuoteApi
) : QuoteDataSource {
    override suspend fun getQuoteList(page: String): NetworkResponse<List<QuoteResult>> =
        try {
            val response = quoteApi.getQuoteList(page).results
            NetworkResponse.Success(response)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }
}