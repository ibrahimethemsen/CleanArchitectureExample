package com.ibrahim.ethem.sen.cleanarchitectureexample.di.network

import com.ibrahim.ethem.sen.cleanarchitectureexample.data.api.QuoteApi
import com.ibrahim.ethem.sen.cleanarchitectureexample.utility.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {
    @Provides
    @ViewModelScoped
    fun provideQuoteApi() : QuoteApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }
}