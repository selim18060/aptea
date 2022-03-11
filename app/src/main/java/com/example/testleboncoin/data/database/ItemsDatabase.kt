package com.example.testleboncoin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testleboncoin.data.model.ItemsData

@Database(
    entities = [ItemsData::class],
    version = 1, exportSchema = false
)

abstract class ItemsDatabase : RoomDatabase() {
    abstract val ItemsDao: ItemsDao
}