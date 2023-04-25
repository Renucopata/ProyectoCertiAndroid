package com.first.mascotapp.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepalace.chatbot.utils.BotResponse
import com.codepalace.chatbot.utils.Constants
import com.codepalace.chatbot.utils.Time
import com.first.mascotapp.R
import com.first.mascotapp.adapters.MessagingAdapter
import com.first.mascotapp.models.Message
import kotlinx.coroutines.*

class ChatBotFragment : Fragment() {

    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("Ignacio", "Andrea", "Fernando", "Maria")

    private lateinit var btn_send: Button
    private lateinit var et_message: EditText
    private lateinit var rv_messages: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat_bot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_send = view.findViewById(R.id.btn_send)
        et_message = view.findViewById(R.id.et_message)
        rv_messages = view.findViewById(R.id.rv_messages)
        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("¡Hola! Hoy está hablando con ${botList[random]}, ¿en qué puedo ayudarte?")
    }

    private fun clickEvents() {

        //Enviar mensaje
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Volver a la posición correcta cuando el usuario hace clic en la vista de texto
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(context)

    }

    override fun onStart() {
        super.onStart()
        //En caso de que haya mensajes, desplazar hasta la parte inferior al volver a abrir el chat
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Se añade a la lista local
            messagesList.add(Message(message, Constants.SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertMessage(Message(message, Constants.SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Retraso de respuesta falso
            delay(1000)

            withContext(Dispatchers.Main) {
                //Obtener respuesta
                val response = BotResponse.basicResponses(message)

                //Se añade a la lista local
                messagesList.add(Message(response, Constants.RECEIVE_ID, timeStamp))

                //Inserta el mensaje en el adaptador
                adapter.insertMessage(Message(response, Constants.RECEIVE_ID, timeStamp))

                //Desplazar a la posición del último mensaje
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Inicio Google
                when (response) {
                    Constants.OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    Constants.OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }

                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, Constants.RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, Constants.RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}