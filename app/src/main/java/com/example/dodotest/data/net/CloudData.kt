package com.example.dodotest.data.net

import com.example.dodotest.data.storage.model.cloudModel.ItemCloud
import retrofit2.Response
import javax.inject.Inject

interface CloudData {

    suspend fun fetchCloud(): Response<ItemCloud>

    class Base @Inject constructor(private val service: Service) : CloudData {
        override suspend fun fetchCloud(): Response<ItemCloud> = service.fetchCloud()
    }
}