package com.example.dodotest.data.storage.model.cacheModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class DataCache(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val best_seller: List<BestSellerCache>,
    val home_store: List<HomeStoreCache>
)

