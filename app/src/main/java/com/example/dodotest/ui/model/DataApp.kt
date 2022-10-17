package com.example.dodotest.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataApp(
    val _id: Int,
    val best_seller: List<BestSellerApp>,
    val home_store: List<HomeStoreApp>
) : Parcelable