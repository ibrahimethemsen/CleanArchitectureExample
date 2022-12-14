package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteDetailEntity
import javax.inject.Inject

class QuoteDomainMapperImpl @Inject constructor() : Mapper<QuoteResult,QuoteDetailEntity> {
    override fun map(input: QuoteResult?): QuoteDetailEntity {
        return input?.let {
            QuoteDetailEntity(
                id = it.id.orEmpty(),
                author = it.author.orEmpty(),
                content = it.content.orEmpty(),
                tags = it.tags.orEmpty()
            )
        }!!
    }
}