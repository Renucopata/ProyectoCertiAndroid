package com.first.mascotapp.data.persistency

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.first.mascotapp.models.LostItemModel
import com.first.mascotapp.models.ServiceListItem

import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveServiceList(newList: List<ServiceListItem>)

    @Query("SELECT * FROM ServiceListItem")
    fun getServiceList(): Flow<List<ServiceListItem>>


}