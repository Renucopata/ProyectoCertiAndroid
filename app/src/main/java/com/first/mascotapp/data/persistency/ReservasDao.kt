package com.first.mascotapp.data.persistency

import androidx.room.*
import com.first.mascotapp.models.Reserva
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservasDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertReserva(reserva: Reserva)

    @Query("SELECT * FROM Reserva WHERE id = :id")
    fun getReserva(id: String): Flow<List<Reserva>>

    @Delete
    fun deleteReserva(reserva: Reserva)
}