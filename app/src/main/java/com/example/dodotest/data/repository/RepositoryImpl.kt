package com.example.dodotest.data.repository

import com.example.dodotest.domain.Repository
import com.example.dodotest.domain.model.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val cloudSource: CloudSource,
    private val exceptionHandle: ExceptionHandle
) : Repository {

    override val allItems: Result
        get() = try {
            Result.Success(cloudSource.fetchCloud())
        } catch (e: Exception) {
            exceptionHandle.handle(e)
        }
}