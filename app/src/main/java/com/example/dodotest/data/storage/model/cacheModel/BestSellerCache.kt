package com.example.dodotest.data.storage.model.cacheModel

data class BestSellerCache(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
)