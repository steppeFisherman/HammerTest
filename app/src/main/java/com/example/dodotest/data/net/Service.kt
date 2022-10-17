package com.example.dodotest.data.net

import com.example.dodotest.data.storage.model.cloudModel.DataCloud
import retrofit2.http.GET

interface Service {

    companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun fetchCloud(): DataCloud
}
