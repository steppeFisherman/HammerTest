package com.example.dodotest.domain.model

data class DataDomain(
    val _id: Int,
    val best_seller: List<BestSellerDomain>,
    val home_store: List<HomeStoreDomain>
)