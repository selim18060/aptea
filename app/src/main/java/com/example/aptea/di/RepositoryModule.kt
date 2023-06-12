package com.example.aptea.di

import android.content.Context
import com.example.aptea.data.database.ItemsDao
import com.example.aptea.domain.ItemsRepository
import com.example.aptea.domain.ItemsRepositoryImpl
import com.example.aptea.network.service.ItemsApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideItemRepository(api: ItemsApi, context: Context, dao : ItemsDao): ItemsRepository {
        return ItemsRepositoryImpl(api, context, dao)
    }
    single { provideItemRepository(get(), androidContext(), get()) }

}