package com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.authors


import com.google.gson.annotations.SerializedName

data class AuthorsResult(
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("dateAdded")
    val dateAdded: String?,
    @SerializedName("dateModified")
    val dateModified: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("quoteCount")
    val quoteCount: Int?,
    @SerializedName("slug")
    val slug: String?
)