package com.first.mascotapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteApi {

    /*val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.6:8000/") // TODO: Aqui reemplazar por su IP de su server mock!
        .addCallAdapterFactory(FlowCallAdapterFactory.create()) // Requerido para utilizar flow para las llamadas asincronas
        .addConverterFactory(GsonConverterFactory.create()) // Requerido para la serializacion/deserializacion
        .build()

    //Como ultimo paso, definir una interfaz que exponga los metodos que tiene nuestro servidor mock, y crear una instancia de un cliente retrofit con ello, por ejemplo:

    interface Api {
        @GET("stores/list")
        fun getStoresList(): Flow<List<HomeListItem>>

        @GET("stores/{id}")
        fun getStoreById(@Url id: String): Flow<List<HomeListItem>>
    }

   val client = retrofit.create(Api::class.java)*/

}