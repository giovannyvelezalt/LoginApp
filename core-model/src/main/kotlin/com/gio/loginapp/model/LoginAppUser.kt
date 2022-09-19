package com.gio.loginapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class LoginAppUser(
  val gender: String,
  val name: String,
  val location: String,
  val email: String,
  val login: String,
  val dateOfBirth: Long,
  val registrationDate: Long,
  val phone: String,
  val cell: String,
  val picture: String,
  val nationality: String
) : Parcelable
