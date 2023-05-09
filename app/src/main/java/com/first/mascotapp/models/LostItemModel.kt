package com.first.mascotapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class LostItemModel (
    @PrimaryKey val petName: String,
    val lastSeen: String,
    val imageUrl: String
): Serializable