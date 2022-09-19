package com.gio.loginapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun LoginAppNavHost(
  navHostController: NavHostController,
  composeNavigator: AppNavigator
) {
  NavHost(
    navController = navHostController,
    startDestination = LoginAppScreens.Login.route
  ) {
    loginAppHomeNavigation(
      composeNavigator = composeNavigator
    )
  }
}
