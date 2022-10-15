package com.example.dodotest.ui.di

import com.example.dodotest.domain.FetchUseCase
import com.example.dodotest.domain.Repository
import com.example.dodotest.ui.model.MapDomainToUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideFetchUseCase(repository: Repository): FetchUseCase =
        FetchUseCase.Base(repository = repository)

    @Provides
    fun provideMapDomainToApp(): MapDomainToUi =
        MapDomainToUi.Base()
}