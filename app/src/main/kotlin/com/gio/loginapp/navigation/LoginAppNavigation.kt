package com.gio.loginapp.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gio.loginapp.login.LoginAppLogin
import com.gio.loginapp.model.LoginAppUser

fun NavGraphBuilder.loginAppHomeNavigation(
    composeNavigator: AppNavigator
) {
    composable(route = LoginAppScreens.Login.name) {
        LoginAppLogin(composeNavigator, hiltViewModel())
    }

    composable(
        route = LoginAppScreens.Home.name,
        arguments = LoginAppScreens.Home.navArguments
    ) {
        val loginppUser =
            it.arguments?.getParcelable<LoginAppUser>(LoginAppScreens.Login.name)
                ?: return@composable


    }
}
