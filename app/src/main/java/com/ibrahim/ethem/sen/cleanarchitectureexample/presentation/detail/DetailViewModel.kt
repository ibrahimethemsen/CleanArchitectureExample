package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation.detail

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.ethem.sen.cleanarchitectureexample.R
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.NetworkResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteDetailEntity
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase.GetQuoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val quoteUseCase : GetQuoteListUseCase
) : ViewModel() {
    private val _getQuote = MutableLiveData<QuoteDetailUiState>()
    val getQuote : LiveData<QuoteDetailUiState> get() = _getQuote

    fun getQuote(id : String) {
        viewModelScope.launch {
            quoteUseCase.getQuote(id).collect{
                when(it){
                    is NetworkResponse.Error -> {
                        _getQuote.postValue(
                            QuoteDetailUiState(
                                isLoading = false,
                                message = R.string.error_msg
                            )
                        )
                    }
                    NetworkResponse.Loading -> {
                        _getQuote.postValue(
                            QuoteDetailUiState(
                                isLoading = true
                            )
                        )
                    }
                    is NetworkResponse.Success -> {
                        _getQuote.postValue(
                            QuoteDetailUiState(
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

data class QuoteDetailUiState(
    val isLoading : Boolean = true,
    val data : QuoteDetailEntity? = null,
    @StringRes val message : Int? = null
)