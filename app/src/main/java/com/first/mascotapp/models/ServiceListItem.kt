package com.first.mascotapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ServiceListItem(

    @PrimaryKey val serviceId: Int,
    val provider: String,
    val description: String,
    val logoUrl: String
): Serializable

