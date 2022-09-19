package com.gio.loginapp.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.gio.loginapp.model.LoginAppUser
import com.gio.loginapp.navigation.navtypes.LoginAppUserType

sealed class LoginAppScreens(
    val route: String,
    val index: Int? = null,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    // login screen
    object Login : LoginAppScreens("login")

    // home screen
    object Home : LoginAppScreens("home",
        navArguments = listOf(
            navArgument("user") {
                type = LoginAppUserType()
                nullable = false
            }
        )) {
        const val KEY_USER = "user"
        fun createRoute(loginAppUser: LoginAppUser) =
            name.replace(
                "{${navArguments.first().name}}",
                LoginAppUserType.encodeToString(loginAppUser)
            )
    }
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}
