package com.gio.loginapp.data.repository

import android.util.Log
import com.gio.loginapp.data.model.toModel
import com.gio.loginapp.database.dao.LoginAppUserDao
import com.gio.loginapp.database.entity.asEntity
import com.gio.loginapp.model.LoginAppUser
import com.gio.loginapp.network.Dispatcher
import com.gio.loginapp.network.LoginAppDispatchers
import com.gio.loginapp.network.service.LoginAppUserService
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

class UserRepositoryImpl @Inject constructor(
    @Dispatcher(LoginAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val loginAppUserService: LoginAppUserService,
    private val loginAppUserDao: LoginAppUserDao
) : UserRepository {

    override suspend fun getUsers(): List<LoginAppUser> {
        Log.e("TAG", "Repo INI")

        val offlineUsers = loginAppUserDao.getLoginAppUsers()
        return if (offlineUsers.isEmpty()) {
            val result = loginAppUserService.fetchLoginAppUsers()
            updateUsers(result)
            result
        } else {
            offlineUsers.map { it.toModel() }
        }
    }

    override suspend fun getUser(user: String, passwd: String): Result<LoginAppUser> {
        val offlineUsers = loginAppUserDao.getLoginAppUsers()
        Log.e("TAG", "Repo INI")

        println("Repo INI")

        if (offlineUsers.isEmpty()) {
            val result = loginAppUserService.fetchLoginAppUsers()
            var userFound: LoginAppUser? = result?.find { foundUser ->
                foundUser.login == user
            }

            return if (result != null && result.isNotEmpty() && userFound != null) {
                println("Repo Success $userFound")
                Result.success(userFound)
            } else {
                println("Repo Failure")
                Result.failure(Exception("User Not Found"))
            }
        } else {
            println("Repo Failure 2")
            return Result.failure(Exception("User Not Found"))
        }
    }

    override suspend fun updateUsers(loginappUsers: List<LoginAppUser>) {
        val entities = loginappUsers?.map { it.asEntity() } ?: return
        loginAppUserDao.insertLoginAppUsers(entities)
    }
}
