package com.first.mascotapp.data.persistency

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.first.mascotapp.models.LostItemModel
import com.first.mascotapp.models.ServiceListItem
import com.first.mascotapp.models.User
import com.first.mascotapp.models.Reserva


@Database(entities = [LostItemModel::class,ServiceListItem::class, User::class, Reserva::class], version = 1)

abstract class RoomPersistency: RoomDatabase() {

    abstract fun lostDao(): LostDao

    abstract fun serviceDao(): ServiceDao

    abstract fun usersDao(): UsersDao

    abstract fun reservasDao(): ReservasDao

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


