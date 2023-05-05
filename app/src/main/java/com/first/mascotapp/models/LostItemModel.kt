package com.first.mascotapp.models

import java.io.Serializable

data class LostItemModel (
    val petName: String,
    val lastSeen: String,
    val imageResource: Int
): Serializable