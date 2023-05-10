package com.first.mascotapp.data.clients

import com.first.mascotapp.models.LostItemModel
import com.first.mascotapp.models.ServiceListItem
import kotlinx.coroutines.flow.Flow
import me.sianaki.flowretrofitadapter.FlowCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class ClienteApi {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.177:8000/") // TODO: Aqui reemplazar por su IP de su server mock!
        .addCallAdapterFactory(FlowCallAdapterFactory.create()) // Requerido para utilizar flow para las llamadas asincronas
        .addConverterFactory(GsonConverterFactory.create()) // Requerido para la serializacion/deserializacion
        .build()

    //Como ultimo paso, definir una interfaz que exponga los metodos que tiene nuestro servidor mock, y crear una instancia de un cliente retrofit con ello, por ejemplo:

    interface Api {
       @GET("lost/list")
        fun getLostList(): Flow<List<LostItemModel>>

        @GET("service/list")
        fun getServiceList(): Flow<List<ServiceListItem>>

    }

   val client = retrofit.create(Api::class.java)

    fun getLostList(): Flow<List<LostItemModel>> {
        return client.getLostList()
    }

    fun getServiceList(): Flow<List<ServiceListItem>> {
        return client.getServiceList()
    }

}