package com.first.mascotapp.Data.repositories

import com.first.mascotapp.Data.clients.ClienteApi
import com.first.mascotapp.models.ServiceListItem
import kotlinx.coroutines.flow.Flow


class ServicesRepository { //TODO conectar con la vista a traves de un view
    val cliente = ClienteApi()


    fun getServiceList(): Flow<List<ServiceListItem>> {
        return cliente.getServiceList()
    }
}