package com.example.testleboncoin.di

import android.app.Application
import androidx.room.Room
import com.example.testleboncoin.data.database.ItemsDao
import com.example.testleboncoin.data.database.ItemsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): ItemsDatabase {
        return Room.databaseBuilder(application, ItemsDatabase::class.java, "items")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideItemsDao(database: ItemsDatabase): ItemsDao {
        return  database.itemsDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideItemsDao(get()) }


}