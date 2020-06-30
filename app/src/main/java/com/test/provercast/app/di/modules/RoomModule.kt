package com.test.provercast.app.di.modules

import android.content.Context
import androidx.room.Room
import com.test.provercast.repository.database.LastResultDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context) =
        Room.databaseBuilder(context, LastResultDatabase::class.java, "database.db").build()


}