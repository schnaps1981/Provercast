package com.test.provercast.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.provercast.repository.network.entity.GoogleSERP

@Database(entities = [GoogleSERP::class], version = 1, exportSchema = false)
abstract class LastResultDatabase: RoomDatabase() {
    abstract fun LastResultDao() : LastResultDao
}