package com.first.mascotapp.data.repositories

import android.content.Context
import android.net.ConnectivityManager
import com.first.mascotapp.data.clients.ClienteApi
import com.first.mascotapp.data.persistency.RoomPersistency
import com.first.mascotapp.models.LostItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


class LostRepository { //TODO conectar con la vista a traves de un view
    val cliente = ClienteApi()


    fun getLostList(context: Context):  Flow<List<LostItemModel>>{
        val persistency = RoomPersistency.getInstance(context)
        return persistency.lostDao().getLostList()
    }


   suspend fun updateLostList(context : Context) {
        val persistency = RoomPersistency.getInstance(context)
       if(isNetworkAvailable(context)){
           val newList = cliente.getLostList().first()
           persistency.lostDao().saveLostList(newList)
       }

    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return manager!!.activeNetworkInfo?.isConnected ?: false
    }
}