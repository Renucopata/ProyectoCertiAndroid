package com.first.mascotapp.models

import java.io.Serializable

data class ServiceListItem(
    val name: String,
    val description: String,
    val coverImageUrl: String,
    val logoUrl: String,
    val contact: String

): Serializable

