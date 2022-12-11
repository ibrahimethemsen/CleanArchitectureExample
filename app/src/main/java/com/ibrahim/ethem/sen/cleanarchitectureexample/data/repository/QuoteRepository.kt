package com.ibrahim.ethem.sen.cleanarchitectureexample.data.repository

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.QuoteResult

interface QuoteRepository {
    suspend fun getQuoteList(page : String) : NetworkResponse<List<QuoteResult>>
}