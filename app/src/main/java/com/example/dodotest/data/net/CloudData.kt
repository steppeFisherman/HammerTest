package com.example.dodotest.data.net

import com.example.dodotest.data.storage.model.cloudModel.DataCloud
import javax.inject.Inject

interface CloudData {

    suspend fun fetchCloud(): DataCloud

    class Base @Inject constructor(private val service: Service) : CloudData {
        override suspend fun fetchCloud(): DataCloud = service.fetchCloud()
    }
}