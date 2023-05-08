package com.first.mascotapp.models

//data class Message(val message: String, val id: String, val time: String)

class Message{
    var message: String = ""
    var id: String = ""
    var time: String = ""

    constructor(message: String, id: String, time: String):this(){
        this.message = message
        this.id = id
        this.time = time
    }

    constructor()
}