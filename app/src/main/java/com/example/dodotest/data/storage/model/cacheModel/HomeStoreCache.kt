package com.example.dodotest.data.storage.model.cacheModel

data class HomeStoreCache(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)