package com.example.dodotest.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.dodotest.data.net.CloudData
import com.example.dodotest.data.storage.room.AppRoomDao
import com.example.dodotest.domain.model.DataDomain
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import javax.inject.Inject

interface CloudSource {

    fun fetchCloud(): MutableLiveData<List<DataDomain>>

    class InitialFetchFromCache @Inject constructor(
        private val appDao: AppRoomDao,
        private val mapperCacheToDomain: MapCacheToDomain,
        private val mapperCloudToCache: MapCloudToCache,
        private val cloudData: CloudData,
        private val dispatchers: ToDispatch,
    ) : CloudSource {

        private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }
        private val scope = CoroutineScope(Job() + exceptionHandler)

        override fun fetchCloud(): MutableLiveData<List<DataDomain>> {
            val item = MutableLiveData<List<DataDomain>>()
            dispatchers.launchIO(scope = scope) {
                val cacheList = appDao.fetchAllItemsBySuspend()
                if (cacheList.isNullOrEmpty()) {
                    val cloud = cloudData.fetchCloud()
                    val cache = mapperCloudToCache.mapCloudToCacheData(cloud)
                    appDao.insertItem(cache)
                    dispatchers.launchUI(this) {
                        item.value = listOf(mapperCacheToDomain.mapCacheToDomainData(cache))
                    }
                } else {
                    dispatchers.launchUI(this) {
                        item.value = cacheList.map { dataCache ->
                            mapperCacheToDomain.mapCacheToDomainData(dataCache)
                        }
                    }
                }
            }
            return item
        }
    }
}