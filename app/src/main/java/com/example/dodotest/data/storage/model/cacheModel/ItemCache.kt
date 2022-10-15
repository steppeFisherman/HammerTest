package com.example.dodotest.data.storage.model.cacheModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class ItemCache(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: Int
)
