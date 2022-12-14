package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model

data class QuoteDetailEntity(
    val id : String,
    val author : String,
    val content : String,
    val tags : List<String?>
)
