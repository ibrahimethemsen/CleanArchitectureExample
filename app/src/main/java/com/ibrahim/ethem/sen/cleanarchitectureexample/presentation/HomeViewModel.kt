package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation

import androidx.lifecycle.ViewModel
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase.GetQuoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val quoteUseCase : GetQuoteListUseCase
): ViewModel() {

    init {
        val a = quoteUseCase.invoke("1")
        println("a : $a")
    }
}