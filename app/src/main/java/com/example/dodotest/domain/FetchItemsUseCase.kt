package com.example.dodotest.domain

import com.example.dodotest.domain.model.Result
import javax.inject.Inject

interface FetchItemsUseCase {

    fun execute(): Result

    class Base @Inject constructor(private val repository: Repository) : FetchItemsUseCase {
        override fun execute(): Result = repository.allItems
    }
}