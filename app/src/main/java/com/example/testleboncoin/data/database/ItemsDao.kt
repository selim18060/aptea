package com.example.testleboncoin.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testleboncoin.data.model.ItemsData

@Dao
interface ItemsDao {

    @Query("SELECT * FROM Items")
    fun findAll(): List<ItemsData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<ItemsData>)
}