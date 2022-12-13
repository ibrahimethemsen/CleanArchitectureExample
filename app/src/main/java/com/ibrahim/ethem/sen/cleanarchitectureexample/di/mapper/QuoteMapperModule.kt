package com.ibrahim.ethem.sen.cleanarchitectureexample.di.mapper

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.quote.QuoteResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.dto.search.SearchResult
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper.ListMapper
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper.QuoteDomainListMapperImpl
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper.SearchDomainListMapperImpl
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class QuoteMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindQuoteMapper(quoteDomainListMapperImpl: QuoteDomainListMapperImpl) : ListMapper<QuoteResult,QuoteEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSearchQuoteMapper(searchDomainListMapperImpl: SearchDomainListMapperImpl) : ListMapper<SearchResult,QuoteEntity>
}