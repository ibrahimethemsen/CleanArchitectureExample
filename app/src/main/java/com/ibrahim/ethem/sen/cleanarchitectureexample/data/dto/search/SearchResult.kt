package com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search


import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("author")
    val author: String?,
    @SerializedName("authorId")
    val authorId: String?,
    @SerializedName("authorSlug")
    val authorSlug: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("dateAdded")
    val dateAdded: String?,
    @SerializedName("dateModified")
    val dateModified: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("length")
    val length: Int?,
    @SerializedName("tags")
    val tags: List<String?>?
)