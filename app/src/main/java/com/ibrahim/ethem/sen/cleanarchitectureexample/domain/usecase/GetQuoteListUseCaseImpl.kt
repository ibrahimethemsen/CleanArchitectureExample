package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search.SearchResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.repository.QuoteRepository
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper.ListMapper
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuoteListUseCaseImpl @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val listMapper: ListMapper<QuoteResult, QuoteEntity>,
    private val searchMapper : ListMapper<SearchResult,QuoteEntity>
) : GetQuoteListUseCase {
    override fun invoke(page: String): Flow<NetworkResponse<List<QuoteEntity>>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = quoteRepository.getQuoteList(page)) {
                is NetworkResponse.Success -> emit(NetworkResponse.Success(listMapper.map(response.result)))
                is NetworkResponse.Error -> emit(response)
                NetworkResponse.Loading -> Unit
            }
        }

    override fun searchUseCase(search: String): Flow<NetworkResponse<List<QuoteEntity>>> = flow {
        emit(NetworkResponse.Loading)
        when(val response = quoteRepository.searchQuote(search)){
            is NetworkResponse.Error -> emit(response)
            NetworkResponse.Loading -> Unit
            is NetworkResponse.Success -> emit(NetworkResponse.Success(searchMapper.map(response.result)))
        }
    }
}