package com.ibrahim.ethem.sen.cleanarchitectureexample.data.repository

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search.SearchResult

interface QuoteRepository {
    suspend fun getQuoteList(page : String) : NetworkResponse<List<QuoteResult>>
    suspend fun searchQuote(search : String) : NetworkResponse<List<SearchResult>>
    suspend fun getQuote(id : String) : NetworkResponse<QuoteResult>
}