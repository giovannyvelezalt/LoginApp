package com.gio.loginapp.navigation

import com.gio.loginapp.R.string.home_page
import com.gio.loginapp.designsystem.icon.Icon
import com.gio.loginapp.designsystem.icon.LoginAppIcons

data class TopLevelDestination(
    val route: String,
    val selectedIcon: Icon? = null,
    val unselectedIcon: Icon? = null,
    val iconTextId: Int? = null
)

val TOP_LEVEL_DESTINATIONS = listOf(

    TopLevelDestination(
        route = LoginAppPage.Login.route,
        selectedIcon = Icon.ImageVectorIcon(LoginAppIcons.PeopleAlt),
        unselectedIcon = Icon.ImageVectorIcon(LoginAppIcons.PeopleAlt)
    ),
    TopLevelDestination(
        route = LoginAppPage.Home.route,
        iconTextId = home_page
    )
)

sealed class LoginAppPage(
    val route: String,
    val index: Int
) {
    object Login : LoginAppPage("login", index = 0)
    object Home : LoginAppPage("home", index = 1)
}
