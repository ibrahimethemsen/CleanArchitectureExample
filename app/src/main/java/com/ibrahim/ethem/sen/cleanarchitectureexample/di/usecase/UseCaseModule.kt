package com.ibrahim.ethem.sen.cleanarchitectureexample.di.usecase

import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase.GetQuoteListUseCase
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.usecase.GetQuoteListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindUseCase(getQuoteListUseCaseImpl: GetQuoteListUseCaseImpl) : GetQuoteListUseCase
}