package com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.authors


import com.google.gson.annotations.SerializedName

data class AuthorsResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<AuthorsResult?>?,
    @SerializedName("totalCount")
    val totalCount: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?
)