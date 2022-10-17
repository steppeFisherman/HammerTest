package com.example.dodotest.data.repository

import com.example.dodotest.domain.model.ErrorType
import com.example.dodotest.domain.model.Result
import retrofit2.HttpException
import java.net.UnknownHostException

interface ExceptionHandle {

    fun handle(e: Exception): Result

    class Base : ExceptionHandle {
        override fun handle(e: Exception): Result = Result.Fail(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is NullPointerException -> ErrorType.NULL_POINTER_EXCEPTION
                is HttpException -> ErrorType.HTTP_EXCEPTION
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}
