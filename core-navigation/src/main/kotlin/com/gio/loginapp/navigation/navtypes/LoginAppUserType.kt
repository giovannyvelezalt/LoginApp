package com.gio.loginapp.navigation.navtypes

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.gio.loginapp.model.LoginAppUser
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LoginAppUserType : NavType<LoginAppUser>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): LoginAppUser? =
        bundle.getParcelable(key)

    override fun put(bundle: Bundle, key: String, value: LoginAppUser) =
        bundle.putParcelable(key, value)

    override fun parseValue(value: String): LoginAppUser {
        return Json.decodeFromString(value)
    }

    companion object {
        fun encodeToString(loginAppUser: LoginAppUser): String {
            return Uri.encode(Json.encodeToString(loginAppUser))
        }
    }
}
