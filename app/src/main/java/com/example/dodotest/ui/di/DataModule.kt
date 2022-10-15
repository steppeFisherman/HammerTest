package com.example.dodotest.ui.di

import android.content.Context
import com.example.dodotest.data.net.CloudData
import com.example.dodotest.data.net.Service
import com.example.dodotest.data.repository.RepositoryImpl
import com.example.dodotest.data.repository.ToDispatch
import com.example.dodotest.data.storage.room.AppRoomDao
import com.example.dodotest.data.storage.room.AppRoomDatabase
import com.example.dodotest.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Service.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)

    @Provides
    @Singleton
    fun provideCloud(service: Service): CloudData = CloudData.Base(service)

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context): AppRoomDao =
        AppRoomDatabase.getInstance(context = context).getAppRoomDao()

    @Provides
    fun provideDispatchers(): ToDispatch = ToDispatch.Base()

    @Provides
    @Singleton
    fun provideRepository(
        appDao: AppRoomDao,
        cloudData: CloudData,
        dispatchers: ToDispatch,
    ): Repository = RepositoryImpl(
        appDao = appDao,
        cloudData = cloudData,
        dispatchers = dispatchers
    )
}