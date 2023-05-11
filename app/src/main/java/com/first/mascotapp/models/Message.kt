package com.first.mascotapp.models

//message: String --> va a ser el mensaje que envia el usuario
//id: String --> va a ser quien envio el mensaje y quien recibe el mensaje
//time: String --> va a tomar una marca de tiempo en caso de que se desee mostrar cuando se envio el mensaje
data class Message(val message: String, val id: String, val time: String)