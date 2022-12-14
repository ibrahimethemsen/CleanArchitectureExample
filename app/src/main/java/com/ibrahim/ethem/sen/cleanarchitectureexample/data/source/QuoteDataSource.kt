package com.ibrahim.ethem.sen.cleanarchitectureexample.data.source

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search.SearchResult

interface QuoteDataSource {
    suspend fun getQuoteList(page : String) : NetworkResponse<List<QuoteResult>>

    suspend fun searchQuoteList(search : String) : NetworkResponse<List<SearchResult>>

    suspend fun getQuote(id : String) : NetworkResponse<QuoteResult>
}