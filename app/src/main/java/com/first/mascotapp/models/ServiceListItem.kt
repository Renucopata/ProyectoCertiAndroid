package com.first.mascotapp.models

import java.io.Serializable

data class ServiceListItem(
    val provider: String,
    val description: String,
    val logo: Int
): Serializable

