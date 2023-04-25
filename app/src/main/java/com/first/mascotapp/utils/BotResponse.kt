package com.codepalace.chatbot.utils

import com.codepalace.chatbot.utils.Constants.OPEN_GOOGLE
import com.codepalace.chatbot.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..1).random()
        val message =_message.toLowerCase()

        return when {

            //Hola
            message.contains("hola") -> {
                when (random) {
                    0 -> "¡Gracias por contactarnos!"
                    1 -> "Gracias por ponerte en contacto con nosotros."
                    else -> "error" }
            }

            //Veterinarias
            message.contains("me podrias dar nombres de veterinarias?") -> {
                when (random) {
                    0 -> "Claro, puedo darte nombres de veterinarias. Aquí te tengo algunas: Clinica Veterinaria Kiltros, Clínica veterinaria Doberman, Clínica Veterinaria America"
                    1 -> "¡Claro! Algunas de las veterinarias son: Clinica Veterinaria Kiltros, Clínica veterinaria Doberman, Clínica Veterinaria America"
                    else -> "error" }
            }

            //Tiendas
            message.contains("me podrias dar nombres de tiendas?") -> {
                when (random) {
                    0 -> "Claro, puedo darte nombres de tiendas. Aquí te tengo algunas: Animall, Jach'a Pet, Super Mercado de Mascotas"
                    1 -> "¡Claro! Algunas de las tiendas son: Animall, Jach'a Pet, Super Mercado de Mascotas"
                    else -> "error" }
            }

            //Gracias
            message.contains("gracias") -> {
                when (random) {
                    0 -> "¡De nada! Recuerda que puedes utilizar nuestro chatbot para buscar información en Google o abrir Google directamente desde aquí si lo necesitas."
                    1 -> "¡De nada! También puedes utilizar nuestro chatbot para buscar información en Google o abrir Google directamente desde aquí si lo necesitarás."
                    else -> "error" }
            }

            //Abrir Google
            message.contains("abrir") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Búsqueda en Internet
            message.contains("buscar")-> {
                OPEN_SEARCH
            }

            //Cuando el programa no lo entiende
            else -> {
                when (random) {
                    0 -> "No entiendo."
                    1 -> "Intenta preguntarme algo diferente."
                    else -> "error"
                }
            }
        }
    }
}