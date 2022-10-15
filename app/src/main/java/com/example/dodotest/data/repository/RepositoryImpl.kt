package com.example.dodotest.data.repository

import com.example.dodotest.data.net.CloudData
import com.example.dodotest.data.storage.room.AppRoomDao
import com.example.dodotest.domain.Repository
import com.example.dodotest.domain.model.ErrorType
import com.example.dodotest.domain.model.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val appDao: AppRoomDao,
    private val cloudData: CloudData,
    private val dispatchers: ToDispatch,
) : Repository {

    private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }
    private val scope = CoroutineScope(Job() + exceptionHandler)

    override val allItems: Result
        get() = try {

            Result.Fail(ErrorType.GENERIC_ERROR)
        } catch (e: Exception) {
            Result.Fail(
                when (e) {
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is NullPointerException -> ErrorType.NULL_POINTER_EXCEPTION
                    else -> ErrorType.GENERIC_ERROR
                }
            )
        }
}