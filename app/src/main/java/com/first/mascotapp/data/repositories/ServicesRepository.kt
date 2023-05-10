package com.first.mascotapp.data.repositories

import android.content.Context
import android.net.ConnectivityManager
import com.first.mascotapp.data.clients.ClienteApi
import com.first.mascotapp.data.persistency.RoomPersistency
import com.first.mascotapp.models.LostItemModel
import com.first.mascotapp.models.ServiceListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


class ServicesRepository { //TODO conectar con la vista a traves de un view
    val cliente = ClienteApi()

    fun getServiceList(context: Context):  Flow<List<ServiceListItem>>{
        val persistency = RoomPersistency.getInstance(context)
        return persistency.serviceDao().getServiceList()
    }


    suspend fun updateServiceList(context : Context) {
        val persistency = RoomPersistency.getInstance(context)
        if(isNetworkAvailable(context)){
            val newList = cliente.getServiceList().first()
            persistency.serviceDao().saveServiceList(newList)
        }

    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return manager!!.activeNetworkInfo?.isConnected ?: false
    }

}