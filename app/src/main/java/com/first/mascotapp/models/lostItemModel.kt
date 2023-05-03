package com.first.mascotapp.models

import java.io.Serializable

data class lostItemModel (
    val petName: String,
    val lastSeen: String,
    val imageResource: Int
): Serializable