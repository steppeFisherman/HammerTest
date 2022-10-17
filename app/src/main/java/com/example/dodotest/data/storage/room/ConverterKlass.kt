package com.example.dodotest.data.storage.room

import androidx.room.TypeConverter
import com.example.dodotest.data.storage.model.cacheModel.BestSellerCache
import com.example.dodotest.data.storage.model.cacheModel.HomeStoreCache
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ConverterKlass {

    private val gson = Gson()
    private val typeBestSellerCache: Type = object : TypeToken<List<BestSellerCache>>() {}.type
    private val typeHomeStoreCache: Type = object : TypeToken<List<HomeStoreCache>>() {}.type

    @TypeConverter
    fun fromBestSellerCacheList(value: List<BestSellerCache>): String =
        gson.toJson(value, typeBestSellerCache)

    @TypeConverter
    fun toBestSellerCacheList(value: String): List<BestSellerCache> =
        gson.fromJson(value, typeBestSellerCache)

    @TypeConverter
    fun fromHomeStoreCacheList(value: List<HomeStoreCache>): String =
        gson.toJson(value, typeHomeStoreCache)

    @TypeConverter
    fun toHomeStoreCacheList(value: String): List<HomeStoreCache> =
        gson.fromJson(value, typeHomeStoreCache)
}