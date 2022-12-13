package com.ibrahim.ethem.sen.cleanarchitectureexample.di.repository

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.repository.QuoteRepository
import com.ibrahim.ethem.sen.cleanarchitectureexample.data.repository.QuoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped



@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repositoryImpl: QuoteRepositoryImpl) : QuoteRepository
}