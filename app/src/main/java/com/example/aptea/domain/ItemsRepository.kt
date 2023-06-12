package com.example.aptea.domain

import com.example.aptea.data.model.ItemsData
import com.example.aptea.utils.AppResult

interface ItemsRepository {
    suspend fun getAllItems() : AppResult<List<ItemsData>>
}