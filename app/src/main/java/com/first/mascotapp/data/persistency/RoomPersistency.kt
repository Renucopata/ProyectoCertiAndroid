package com.first.mascotapp.data.persistency

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.first.mascotapp.models.LostItemModel


@Database(entities = [LostItemModel::class], version = 1)

abstract class RoomPersistency: RoomDatabase() {

    abstract fun lostDao(): LostDao


    companion object {
        var instance: RoomPersistency? = null

        fun getInstance(context: Context): RoomPersistency {
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    RoomPersistency::class.java,
                    "RoomDb.db"
                ).build()
            }
            return instance!!
        }
    }
}


