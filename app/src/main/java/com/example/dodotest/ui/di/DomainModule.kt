package com.example.dodotest.ui.di

import com.example.dodotest.domain.FetchItemsUseCase
import com.example.dodotest.domain.Repository
import com.example.dodotest.ui.model.MapDomainToApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideFetchItemsUseCase(repository: Repository): FetchItemsUseCase =
        FetchItemsUseCase.Base(repository = repository)

    @Provides
    fun provideMapDomainToApp(): MapDomainToApp = MapDomainToApp.BaseMapDomainToApp()
}