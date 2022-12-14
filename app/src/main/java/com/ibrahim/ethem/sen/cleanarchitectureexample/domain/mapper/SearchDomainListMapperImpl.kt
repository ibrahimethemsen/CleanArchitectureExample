package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search.SearchResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import javax.inject.Inject

class SearchDomainListMapperImpl @Inject constructor() : ListMapper<SearchResult,QuoteEntity> {
    override fun map(input: List<SearchResult>?): List<QuoteEntity> {
        return input?.map {
            QuoteEntity(
                id = it.id.orEmpty(),
                author = it.author.orEmpty(),
                content = it.content.orEmpty()
            )
        } ?: emptyList()
    }
}