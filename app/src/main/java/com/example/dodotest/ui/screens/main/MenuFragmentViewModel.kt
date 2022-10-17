package com.example.dodotest.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.dodotest.domain.FetchItemsUseCase
import com.example.dodotest.domain.model.ErrorType
import com.example.dodotest.ui.model.DataApp
import com.example.dodotest.ui.model.MapDomainToApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuFragmentViewModel @Inject constructor(
    fetchItemsUseCase: FetchItemsUseCase,
    private val mapper: MapDomainToApp,
) : ViewModel() {

    private var mAllItems = MutableLiveData<List<DataApp>>()
    private var mError = MutableLiveData<ErrorType>()
    val allItems: LiveData<List<DataApp>>
        get() = mAllItems
    val error: LiveData<ErrorType>
        get() = mError

    init {
        when (val result = fetchItemsUseCase.execute()) {
            is com.example.dodotest.domain.model.Result.Success -> {
                mAllItems = result.itemsDomain.map { list ->
                    list.map { mapper.mapDomainToAppData(it) }
                } as MutableLiveData<List<DataApp>>
            }
            is com.example.dodotest.domain.model.Result.Fail -> mError.value = result.errorType
        }
    }
}