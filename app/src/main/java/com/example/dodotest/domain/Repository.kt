package com.example.dodotest.domain

import com.example.dodotest.domain.model.Result

interface Repository {
    val allItems: Result
}