package com.example.dodotest.data.repository

import com.example.dodotest.data.storage.model.cloudModel.BestSellerCloud
import com.example.dodotest.data.storage.model.cloudModel.DataCloud
import com.example.dodotest.data.storage.model.cloudModel.HomeStoreCloud
import com.example.dodotest.domain.model.BestSellerDomain
import com.example.dodotest.domain.model.DataDomain
import com.example.dodotest.domain.model.HomeStoreDomain

interface MapCloudToDomain {

    fun mapCloudToDomainBestSeller(cloudBestSeller: BestSellerCloud): BestSellerDomain
    fun mapCloudToDomainHomeStore(cloudHomeStore: HomeStoreCloud): HomeStoreDomain
    fun mapCloudToDomainData(dataCloud: DataCloud): DataDomain

    class Base : MapCloudToDomain {
        override fun mapCloudToDomainBestSeller(cloudBestSeller: BestSellerCloud): BestSellerDomain =
            BestSellerDomain(
                discount_price = cloudBestSeller.price_without_discount,
                id = cloudBestSeller.id,
                is_favorites = cloudBestSeller.is_favorites,
                picture = cloudBestSeller.picture,
                price_without_discount = cloudBestSeller.discount_price,
                title = cloudBestSeller.title
            )

        override fun mapCloudToDomainHomeStore(cloudHomeStore: HomeStoreCloud): HomeStoreDomain =
            HomeStoreDomain(
                id = cloudHomeStore.id,
                is_buy = cloudHomeStore.is_buy,
                is_new = cloudHomeStore.is_new,
                picture = cloudHomeStore.picture,
                subtitle = cloudHomeStore.subtitle,
                title = cloudHomeStore.title
            )

        override fun mapCloudToDomainData(dataCloud: DataCloud): DataDomain =
            DataDomain(
                _id = 0,
                best_seller = listMapCloudToDomainBestSeller(dataCloud.best_seller),
                home_store = listMapCloudToDomainHomeStore(dataCloud.home_store)
            )

        private fun listMapCloudToDomainBestSeller(list: List<BestSellerCloud>)
                : List<BestSellerDomain> = list.map { cloudBestSeller ->
            mapCloudToDomainBestSeller(cloudBestSeller)
        }

        private fun listMapCloudToDomainHomeStore(list: List<HomeStoreCloud>)
                : List<HomeStoreDomain> = list.map { cloudHomeStore ->
            mapCloudToDomainHomeStore(cloudHomeStore)
        }
    }
}