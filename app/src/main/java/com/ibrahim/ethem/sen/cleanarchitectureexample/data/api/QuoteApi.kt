package com.ibrahim.ethem.sen.cleanarchitectureexample.data.api

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.authors.AuthorsResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResponse
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search.SearchQuote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuoteApi {
    @GET("quotes")
    suspend fun getQuoteList(@Query("page") pageNumber : String) : QuoteResponse

    //parametreler sonrasında -quotes vericez parametreler arasında virgül olucak
    @GET("quotes")
    suspend fun getQuoteListTags(@Query(value = "tags") tagFilter : String) : QuoteResponse

    //Get Quote
    @GET("quotes/{id}")
    suspend fun getQuote(@Path("id") id : String) : QuoteResult

    //Get Authers
    @GET("authors")
    suspend fun getAuthors() : AuthorsResponse

    //Search Quotes
    @GET("search/quotes")
    suspend fun getSearch(@Query("query") search : String) : SearchQuote
}