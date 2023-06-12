package com.example.aptea.di

import com.example.aptea.network.service.ItemsApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideItemsApi(retrofit: Retrofit): ItemsApi {
        return retrofit.create(ItemsApi::class.java)
    }
    single { provideItemsApi(get()) }

}