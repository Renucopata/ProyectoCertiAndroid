package com.first.mascotapp.Data.network

import com.first.mascotapp.models.Message
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class repositorio(val network:chatBotNetworkControler) {
    fun getMessageVeterinaria(): kotlinx.coroutines.flow.Flow<Message> {
        return flow {
            emit(network.getVeterinarias()) }
    }
}