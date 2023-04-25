package com.first.mascotapp.models

import java.io.Serializable

data class ServiceListItem(
    val title: String,
    val coverImageUrl: String,
    val logoUrl: String,

): Serializable

