package com.example.testleboncoin.domain

import androidx.lifecycle.LiveData
import com.example.testleboncoin.data.model.ItemsData
import com.example.testleboncoin.utils.AppResult

interface ItemsRepository {
    suspend fun getAllItems() : AppResult<List<ItemsData>>
}