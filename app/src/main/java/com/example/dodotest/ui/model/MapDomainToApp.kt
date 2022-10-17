package com.example.dodotest.ui.model

import com.example.dodotest.domain.model.BestSellerDomain
import com.example.dodotest.domain.model.DataDomain
import com.example.dodotest.domain.model.HomeStoreDomain

interface MapDomainToApp {

    fun mapDomainToAppBestSeller(domainBestSeller: BestSellerDomain): BestSellerApp
    fun mapDomainToAppHomeStore(domainHomeStore: HomeStoreDomain): HomeStoreApp
    fun mapDomainToAppData(dataDomain: DataDomain): DataApp

    class BaseMapDomainToApp : MapDomainToApp {
        override fun mapDomainToAppBestSeller(domainBestSeller: BestSellerDomain): BestSellerApp =
            BestSellerApp(
                discount_price = domainBestSeller.discount_price,
                id = domainBestSeller.id,
                is_favorites = domainBestSeller.is_favorites,
                picture = domainBestSeller.picture,
                price_without_discount = domainBestSeller.price_without_discount,
                title = domainBestSeller.title
            )

        override fun mapDomainToAppHomeStore(domainHomeStore: HomeStoreDomain): HomeStoreApp =
            HomeStoreApp(
                id = domainHomeStore.id,
                is_buy = domainHomeStore.is_buy,
                is_new = domainHomeStore.is_new,
                picture = domainHomeStore.picture,
                subtitle = domainHomeStore.subtitle,
                title = domainHomeStore.title
            )

        override fun mapDomainToAppData(dataDomain: DataDomain): DataApp =
            DataApp(
                _id = dataDomain._id,
                best_seller = listMapDomainToAppBestSeller(dataDomain.best_seller),
                home_store = listMapDomainToAppHomeStore(dataDomain.home_store)
            )

        private fun listMapDomainToAppBestSeller(list: List<BestSellerDomain>): List<BestSellerApp> =
            list.map { domainBestSeller ->
                mapDomainToAppBestSeller(domainBestSeller)
            }

        private fun listMapDomainToAppHomeStore(list: List<HomeStoreDomain>): List<HomeStoreApp> =
            list.map { domainHomeStore ->
                mapDomainToAppHomeStore(domainHomeStore)
            }
    }

    fun List<Any>.combine(other: List<Any>): List<Any> = mutableListOf<Any>().also {
        val first = iterator()
        val second = other.iterator()
        while (first.hasNext() || second.hasNext()) {
            if (first.hasNext()) it.add(first.next())
            if (second.hasNext()) it.add(second.next())
        }
    }
}