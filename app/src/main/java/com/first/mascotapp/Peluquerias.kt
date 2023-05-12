package com.first.mascotapp

var peluqueriasList = mutableListOf<Peluquerias>()

val PELUQUERIAS_ID_EXTRA = "peluqueriasExtra"

class Peluquerias(
    var cover: Int,
    var title: String,
    var description: String,
    val id: Int? = peluqueriasList.size
)