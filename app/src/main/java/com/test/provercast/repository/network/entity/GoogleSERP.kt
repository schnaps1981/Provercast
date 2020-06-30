package com.test.provercast.repository.network.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lastResult")
data class GoogleSERP (
    @PrimaryKey @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "url") val url : String,
    @ColumnInfo(name = "snippet") val snippet : String
)