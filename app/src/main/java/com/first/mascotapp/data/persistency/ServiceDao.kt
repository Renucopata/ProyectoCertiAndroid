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

    @Query("SELECT * FROM ServiceListItem WHERE serviceId LIKE 1%" +
            "serviceId")
    fun getServiceList1(): Flow<List<ServiceListItem>>
    @Query("SELECT * FROM ServiceListItem WHERE serviceId LIKE 2%" +
            "serviceId")
    fun getServiceList2(): Flow<List<ServiceListItem>>


}