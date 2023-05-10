package com.first.mascotapp.models

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Reserva(id: String, nombreDueno: String, nombreMascota: String, fecha: String, hora: String){
    @PrimaryKey var id: String = id
    var nombreDueno: String = nombreDueno
    var nombreMascota: String = nombreMascota
    var fecha: String = fecha
    var hora: String = hora

}