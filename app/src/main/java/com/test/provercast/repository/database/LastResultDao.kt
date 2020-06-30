package com.test.provercast.repository.database

import androidx.room.*
import com.test.provercast.repository.network.entity.GoogleSERP

@Dao
interface LastResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateDatabase(result : List<GoogleSERP>)

    @Query("SELECT * FROM lastResult")
    suspend fun fetchDatabase() : List<GoogleSERP>

    @Query("DELETE FROM lastResult")
    suspend fun clearDatabase()

    @Transaction
    suspend fun updateLastResult(result: List<GoogleSERP>)
    {
        clearDatabase()
        updateDatabase(result)
    }

}