package com.example.dodotest.data.net

import com.example.dodotest.data.storage.model.cloudModel.ItemCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    companion object {
        const val BASE_URL = ""
        const val API_KEY = ""
    }

    @GET("svc/movies/v2/reviews/all.json")
    suspend fun fetchCloud(@Query("api-key") key: String = API_KEY): Response<ItemCloud>
}