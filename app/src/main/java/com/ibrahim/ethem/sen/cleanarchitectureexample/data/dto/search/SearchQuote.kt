package com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search


import com.google.gson.annotations.SerializedName

data class SearchQuote(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Any?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<SearchResult>,
    @SerializedName("totalCount")
    val totalCount: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?
)