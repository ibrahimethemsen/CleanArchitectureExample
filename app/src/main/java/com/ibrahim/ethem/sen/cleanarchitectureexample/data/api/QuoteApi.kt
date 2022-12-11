package com.ibrahim.ethem.sen.cleanarchitectureexample.data.api

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.QuoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {
    @GET("quotes")
    suspend fun getQuoteList(@Query ("page") pageNumber : String) : QuoteResponse
}