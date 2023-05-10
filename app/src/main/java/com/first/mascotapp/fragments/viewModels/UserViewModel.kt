package com.first.mascotapp.fragments.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.mascotapp.data.repositories.UsersRepository
import com.first.mascotapp.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val usersRepository = UsersRepository()


    fun createUser(context: Context, user: User, onSuccess: () -> Unit, onError: () -> Unit) {
//        TemporalDb.saveUser(user)
        viewModelScope.launch {
            flow {
                usersRepository.registrarUsuario(context, user)
                emit(user)
            }
                .flowOn(Dispatchers.IO)
                .onEach { onSuccess() }
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect{}
        }
    }

    fun login(context: Context, username: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch {
            flow {
                val user = usersRepository.login(context, username, password).first()
                emit(user)
            }
                .flowOn(Dispatchers.IO)
                .onEach { onSuccess() }
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect{}
        }
    }
}