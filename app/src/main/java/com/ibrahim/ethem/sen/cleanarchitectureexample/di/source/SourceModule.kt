package com.ibrahim.ethem.sen.cleanarchitectureexample.di.source

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.source.QuoteDataSource
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.source.QuoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class SourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRemoteDataSource(quoteDataSourceImpl : QuoteDataSourceImpl) : QuoteDataSource
}