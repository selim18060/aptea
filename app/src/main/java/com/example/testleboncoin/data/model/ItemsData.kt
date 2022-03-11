package com.example.testleboncoin.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Items")
@Parcelize
class ItemsData (
    @PrimaryKey(autoGenerate = false) val id: Int,
    val albumId: Int?,
    val title: String?,
    val url: String?,
    val thumbnailUrl: String?
) : Parcelable
