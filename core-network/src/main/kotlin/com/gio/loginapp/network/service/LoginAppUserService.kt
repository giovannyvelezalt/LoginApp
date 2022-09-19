package com.gio.loginapp.network.service

import com.gio.loginapp.model.LoginAppUser
import retrofit2.http.GET

interface LoginAppUserService {

  @GET("RandomPerson.json")
  suspend fun fetchLoginAppUsers(): List<LoginAppUser>
}
