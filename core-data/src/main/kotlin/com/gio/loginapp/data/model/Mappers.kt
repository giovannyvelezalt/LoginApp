package com.gio.loginapp.data.model

import com.gio.loginapp.database.entity.LoginAppUserEntity
import com.gio.loginapp.model.LoginAppUser

fun LoginAppUserEntity.toModel(): LoginAppUser {
    return LoginAppUser(
        gender,
        name,
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
