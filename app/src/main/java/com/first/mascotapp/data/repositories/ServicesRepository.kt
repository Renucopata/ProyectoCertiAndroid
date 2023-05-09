package com.first.mascotapp.data.repositories

import com.first.mascotapp.data.clients.ClienteApi
import com.first.mascotapp.models.LostItemModel
import kotlinx.coroutines.flow.Flow


class ServicesRepository { //TODO conectar con la vista a traves de un view
    val cliente = ClienteApi()

    fun getServicesList(): Flow<List<LostItemModel>> {
        return cliente.getLostList()
    }

}