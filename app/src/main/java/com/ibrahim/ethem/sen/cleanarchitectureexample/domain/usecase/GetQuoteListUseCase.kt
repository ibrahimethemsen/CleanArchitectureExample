package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import kotlinx.coroutines.flow.Flow

interface GetQuoteListUseCase {
    operator fun invoke(page : String) : Flow<NetworkResponse<List<QuoteEntity>>>
}