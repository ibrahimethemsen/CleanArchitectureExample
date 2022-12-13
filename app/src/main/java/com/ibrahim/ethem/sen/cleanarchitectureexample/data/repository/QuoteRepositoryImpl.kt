package com.ibrahim.ethem.sen.cleanarchitectureexample.data.repository

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.source.QuoteDataSource
import com.ibrahim.ethem.sen.cleanarchitectureexample.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteDataSource: QuoteDataSource,
    @IoDispatcher private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : QuoteRepository {
    override suspend fun getQuoteList(page: String): NetworkResponse<List<QuoteResult>> =
        withContext(defaultDispatcher) {
            try {
                quoteDataSource.getQuoteList(page)
            } catch (e: Exception) {
                NetworkResponse.Error(e)
            }
        }
}