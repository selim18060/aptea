package com.example.aptea.core

import android.app.Application
import com.example.aptea.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ItemApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ItemApplication)
            modules(
                apiModule,
                viewModelModule,
                repositoryModule,
                networkModule,
                databaseModule
            )
        }
    }
}