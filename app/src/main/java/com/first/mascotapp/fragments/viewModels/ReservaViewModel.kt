package com.first.mascotapp.fragments.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.mascotapp.data.repositories.AppointmentsRepository
import com.first.mascotapp.models.Reserva
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ReservaViewModel : ViewModel() {
    val appointmentsRepository = AppointmentsRepository()


    fun crearReserva(context: Context, reserva: Reserva, onSuccess: () -> Unit, onError: () -> Unit) {
//        TemporalDb.saveUser(user)
        viewModelScope.launch {
            flow {
                appointmentsRepository.registrarReserva(context, reserva)
                emit(reserva)
            }
                .flowOn(Dispatchers.IO)
                .onEach { onSuccess() }
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect{}
        }
    }
}