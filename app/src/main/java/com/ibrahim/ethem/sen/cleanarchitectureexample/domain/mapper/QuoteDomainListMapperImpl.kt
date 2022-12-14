package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import javax.inject.Inject

class QuoteDomainListMapperImpl @Inject constructor() : ListMapper<QuoteResult,QuoteEntity> {
    override fun map(input: List<QuoteResult>?): List<QuoteEntity> {
        return input?.map {
            QuoteEntity(
                id = it.id.orEmpty(),
                author = it.author.orEmpty(),
                content =it.content.orEmpty()
            )
        } ?: emptyList()
    }
}
