package com.example.testleboncoin.di

import com.example.testleboncoin.network.service.ItemsApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideItemsApi(retrofit: Retrofit): ItemsApi {
        return retrofit.create(ItemsApi::class.java)
    }
    single { provideItemsApi(get()) }

}