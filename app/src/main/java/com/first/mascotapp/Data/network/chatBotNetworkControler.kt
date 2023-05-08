package com.first.mascotapp.Data.network

import com.first.mascotapp.models.Message

interface chatBotNetworkControler {
    suspend fun getVeterinarias(): Message
}