package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteDetailEntity
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import kotlinx.coroutines.flow.Flow

interface GetQuoteListUseCase {
    operator fun invoke(page : String) : Flow<NetworkResponse<List<QuoteEntity>>>
    fun searchUseCase(search : String) : Flow<NetworkResponse<List<QuoteEntity>>>
    fun getQuote(id : String) : Flow<NetworkResponse<QuoteDetailEntity>>
}