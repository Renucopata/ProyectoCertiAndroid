package com.first.mascotapp.data.repositories

import android.content.Context
import com.first.mascotapp.data.persistency.AuthPersistency
import com.first.mascotapp.data.persistency.RoomPersistency
import com.first.mascotapp.models.User

import kotlinx.coroutines.flow.*

class UsersRepository {

    suspend fun registrarUsuario(context: Context, user: User) {
        RoomPersistency.getInstance(context).usersDao().insertUser(user)
        AuthPersistency.saveUser(context, user)
    }

    fun login(context: Context, username: String, password: String): Flow<User> {
        return RoomPersistency.getInstance(context).usersDao().getUser(username, password)
            .map { it.first() }
            .onEach { user -> AuthPersistency.saveUser(context, user) }
    }

    fun logout(context: Context): Flow<Unit> {
        return flow {
            AuthPersistency.removeUser(context)
        }
    }

    suspend fun isLoggedIn(context: Context): Boolean {
        return AuthPersistency.getUser(context)?.first() != null
    }

    suspend fun updatePassword(context: Context, username: String, oldPassword: String, newPassword: String) {
        val user = RoomPersistency.getInstance(context).usersDao().getUser(username, oldPassword).map { it.first() }.first()
        user.password = newPassword
        RoomPersistency.getInstance(context).usersDao().updateUser(user)
    }
}