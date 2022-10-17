package com.example.dodotest.data.repository

import com.example.dodotest.data.storage.model.cacheModel.BestSellerCache
import com.example.dodotest.data.storage.model.cacheModel.DataCache
import com.example.dodotest.data.storage.model.cacheModel.HomeStoreCache
import com.example.dodotest.domain.model.BestSellerDomain
import com.example.dodotest.domain.model.DataDomain
import com.example.dodotest.domain.model.HomeStoreDomain

interface MapCacheToDomain {

    fun mapCacheToDomainBestSeller(cacheBestSeller: BestSellerCache): BestSellerDomain
    fun mapCacheToDomainHomeStore(cacheHomeStore: HomeStoreCache): HomeStoreDomain
    fun mapCacheToDomainData(dataCache: DataCache): DataDomain

    class Base : MapCacheToDomain {
        override fun mapCacheToDomainBestSeller(cacheBestSeller: BestSellerCache): BestSellerDomain =
            BestSellerDomain(
                discount_price = cacheBestSeller.discount_price,
                id = cacheBestSeller.id,
                is_favorites = cacheBestSeller.is_favorites,
                picture = cacheBestSeller.picture,
                price_without_discount = cacheBestSeller.price_without_discount,
                title = cacheBestSeller.title
            )

        override fun mapCacheToDomainHomeStore(cacheHomeStore: HomeStoreCache): HomeStoreDomain =
            HomeStoreDomain(
                id = cacheHomeStore.id,
                is_buy = cacheHomeStore.is_buy,
                is_new = cacheHomeStore.is_new,
                picture = cacheHomeStore.picture,
                subtitle = cacheHomeStore.subtitle,
                title = cacheHomeStore.title
            )

        override fun mapCacheToDomainData(dataCache: DataCache): DataDomain =
            DataDomain(
                _id = dataCache._id,
                best_seller = listMapCacheToDomainBestSeller(dataCache.best_seller),
                home_store = listMapCacheToDomainHomeStore(dataCache.home_store)
            )

        private fun listMapCacheToDomainBestSeller(list: List<BestSellerCache>): List<BestSellerDomain> =
            list.map { cacheBestSeller ->
                mapCacheToDomainBestSeller(cacheBestSeller)
            }

        private fun listMapCacheToDomainHomeStore(list: List<HomeStoreCache>): List<HomeStoreDomain> =
            list.map { cacheHomeStore ->
                mapCacheToDomainHomeStore(cacheHomeStore)
            }
    }
}