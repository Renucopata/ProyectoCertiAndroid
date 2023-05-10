package com.first.mascotapp.models

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Reserva(id: String, nombreDueno: String, nombreMascota: String, fecha: String, hora: String) : BaseObservable() {
    @PrimaryKey var idReserva: String = id
        set(value) {
            field = value
            notifyChange()
        }

    var nombreDuenho: String = nombreDueno
        set(value) {
            field = value
            notifyChange()
        }
    var nombreMascota: String = nombreMascota
        set(value) {
            field = value
            notifyChange()
        }
    var fecha: String = fecha
        set(value) {
            field = value
            notifyChange()
        }
    var hora: String = hora
        set(value) {
            field = value
            notifyChange()
        }


}