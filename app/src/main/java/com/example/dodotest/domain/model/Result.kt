package com.example.dodotest.domain.model

sealed class Result{

    data class Fail(val errorType: ErrorType) : Result()
}
