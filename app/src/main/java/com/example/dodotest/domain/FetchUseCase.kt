package com.example.dodotest.domain

import javax.inject.Inject

interface FetchUseCase {

    fun execute(): com.example.dodotest.domain.model.Result

    class Base @Inject constructor(private val repository: Repository) : FetchUseCase {
        override fun execute(): com.example.dodotest.domain.model.Result = repository.allItems
    }
}