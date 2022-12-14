package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation.home

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.ethem.sen.cleanarchitectureexample.R
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase.GetQuoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val quoteUseCase: GetQuoteListUseCase,
) : ViewModel() {
    private val _quoteList = MutableLiveData<QuoteUiState>()
    val quoteList: LiveData<QuoteUiState> get() = _quoteList


    fun getQuoteList() {
        viewModelScope.launch {
            quoteUseCase("1").collect {
                when (it) {
                    is NetworkResponse.Error -> {
                        _quoteList.postValue(
                            QuoteUiState(
                                isLoading = false,
                                message = R.string.error_msg
                            )
                        )
                    }
                    NetworkResponse.Loading -> {
                        _quoteList.postValue(
                            QuoteUiState(
                                isLoading = true
                            )
                        )
                    }
                    is NetworkResponse.Success -> {
                        _quoteList.postValue(
                            QuoteUiState(
                                isLoading = false,
                                message = null,
                                data = it.result
                            )
                        )
                    }
                }
            }
        }
    }

    fun searchQuote(search: String) {
        viewModelScope.launch {
            quoteUseCase.searchUseCase(search).collect{
                when(it){
                    is NetworkResponse.Error -> {
                        _quoteList.postValue(
                            QuoteUiState(
                                isLoading = false,
                                message = R.string.error_msg
                            )
                        )
                        println("exception -> ${it.exception}")
                    }
                    NetworkResponse.Loading -> {
                        _quoteList.postValue(
                            QuoteUiState(
                                isLoading = true
                            )
                        )
                    }
                    is NetworkResponse.Success -> {
                        _quoteList.postValue(
                            QuoteUiState(
                                isLoading = false,
                                message = null,
                                data = it.result
                            )
                        )
                    }
                }
            }
        }
    }
}


data class QuoteUiState(
    val isLoading: Boolean = true,
    val data: List<QuoteEntity> = emptyList(),
    @StringRes val message: Int? = null
)