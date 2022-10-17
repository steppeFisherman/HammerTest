package com.example.dodotest.data.storage.model.cloudModel


import com.google.gson.annotations.SerializedName

data class DataCloud(
    @SerializedName("best_seller")
    val best_seller: List<BestSellerCloud>,
    @SerializedName("home_store")
    val home_store: List<HomeStoreCloud>
)