package com.example.testleboncoin.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build ItemsViewModel
    viewModel {
        ItemsViewModel(repository = get())
    }

}