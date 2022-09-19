package com.gio.loginapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gio.loginapp.model.LoginAppUser

@Entity(
  tableName = "users"
)
data class LoginAppUserEntity(
  @PrimaryKey val name: String,
  val gender: String,
  val location: String,
  val email: String,
  val login: String,
  val dateOfBirth: Long,
  val registrationDate: Long,
  val phone: String,
  val cell: String,
  val picture: String,
  val nationality: String
)

fun LoginAppUser.asEntity(): LoginAppUserEntity {
  return LoginAppUserEntity(
    name,
    gender,
    location,
    email,
    login,
    dateOfBirth,
    registrationDate,
    phone,
    cell,
    picture,
    nationality
  )
}
