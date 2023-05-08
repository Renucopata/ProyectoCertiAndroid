package com.first.mascotapp.Data.network

import com.first.mascotapp.models.Message
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class chatBotNetworkControlerImp:chatBotNetworkControler {
    val db = Firebase.firestore

    override suspend fun getVeterinarias(): Message {
        val response = db.collection("mensajes").document("veterinaria").get().await()
        return response.toObject(Message::class.java)!!
    }
}