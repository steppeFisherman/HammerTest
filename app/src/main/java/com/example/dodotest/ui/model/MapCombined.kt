package com.example.dodotest.ui.model

interface MapCombined {

    fun combine(list: List<DataApp>): MutableList<DataAppCombined>

    class Base : MapCombined {
        override fun combine(list: List<DataApp>): MutableList<DataAppCombined> {

            val listDataAppCombined = mutableListOf<DataAppCombined>()
            val listBestSeller = list[0].best_seller
            val listHomeStore = list[0].home_store
            val id = list[0]._id

            listDataAppCombined.addAll(
                listBestSeller.map { bestSellerApp ->
                    DataAppCombined(
                        id = id,
                        title = bestSellerApp.title,
                        description = "just some random text for the test purposes jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",
                        picture = bestSellerApp.picture,
                        discount_price = bestSellerApp.discount_price
                    )
                }
            )

            listDataAppCombined.addAll(listHomeStore.map { homeStore ->
                DataAppCombined(
                    id = id,
                    title = homeStore.title,
                    description = "just some random text for the test purposesjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",
                    picture = homeStore.picture,
                    discount_price = (300..700).shuffled().first()
                )
            }
            )

            return listDataAppCombined
        }
    }
}