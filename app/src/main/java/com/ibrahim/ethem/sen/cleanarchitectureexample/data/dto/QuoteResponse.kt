package com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto


import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<QuoteResult>,
    @SerializedName("totalCount")
    val totalCount: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?
)