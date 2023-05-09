package com.first.mascotapp.data.persistency

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.first.mascotapp.models.LostItemModel

import kotlinx.coroutines.flow.Flow

@Dao
interface LostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLostList(newList: List<LostItemModel>)

    @Query("SELECT * FROM LostItemModel")
    fun getLostList(): Flow<List<LostItemModel>>


}