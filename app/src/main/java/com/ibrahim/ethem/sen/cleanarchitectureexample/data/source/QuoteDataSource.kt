package com.ibrahim.ethem.sen.cleanarchitectureexample.data.source

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.QuoteResult

interface QuoteDataSource {
    suspend fun getQuoteList(page : String) : NetworkResponse<List<QuoteResult>>
}