package com.example.testleboncoin.di

import android.content.Context
import com.example.testleboncoin.data.database.ItemsDao
import com.example.testleboncoin.domain.ItemsRepository
import com.example.testleboncoin.domain.ItemsRepositoryImpl
import com.example.testleboncoin.network.service.ItemsApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideItemRepository(api: ItemsApi, context: Context, dao : ItemsDao): ItemsRepository {
        return ItemsRepositoryImpl(api, context, dao)
    }
    single { provideItemRepository(get(), androidContext(), get()) }

}