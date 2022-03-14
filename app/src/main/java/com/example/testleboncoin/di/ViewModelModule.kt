package com.example.testleboncoin.di

import com.example.testleboncoin.ui.list.ItemsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build ItemsViewModel
    viewModel { ItemsViewModel(repository = get()) }

}