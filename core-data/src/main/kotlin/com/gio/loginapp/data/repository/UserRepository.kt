package com.gio.loginapp.data.repository

import com.gio.loginapp.model.LoginAppUser
import kotlinx.coroutines.flow.Flow

interface UserRepository {

  suspend fun getUsers(): List<LoginAppUser>

  suspend fun getUser(user: String, passwd: String): Result<LoginAppUser>

  suspend fun updateUsers(loginappUsers: List<LoginAppUser>)
}
