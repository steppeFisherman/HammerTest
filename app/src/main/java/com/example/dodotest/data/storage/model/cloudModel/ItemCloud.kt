package com.example.dodotest.data.storage.model.cloudModel

import com.google.gson.annotations.SerializedName

data class ItemCloud(
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Int?
)
