package com.first.mascotapp.data.repositories

import android.content.Context
import com.first.mascotapp.data.persistency.AuthPersistency
import com.first.mascotapp.data.persistency.RoomPersistency
import com.first.mascotapp.models.Reserva

class AppointmentsRepository {
    suspend fun registrarReserva(context: Context, reserva: Reserva) {
        RoomPersistency.getInstance(context).reservasDao().insertReserva(reserva)
        AuthPersistency.saveReserva(context, reserva)
    }
}