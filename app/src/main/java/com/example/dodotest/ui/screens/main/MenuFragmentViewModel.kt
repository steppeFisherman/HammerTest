package com.example.dodotest.ui.screens.main

import androidx.lifecycle.ViewModel
import com.example.dodotest.domain.FetchUseCase
import com.example.dodotest.ui.model.MapDomainToUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuFragmentViewModel @Inject constructor(
    fetchItemsUseCase: FetchUseCase,
    private val mapper: MapDomainToUi,
): ViewModel() {



}