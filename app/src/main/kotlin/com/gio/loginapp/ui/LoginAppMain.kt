package com.gio.loginapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.gio.loginapp.designsystem.component.LoginAppBackground
import com.gio.loginapp.designsystem.theme.LoginAppComposeTheme
import com.gio.loginapp.navigation.AppNavigator
import com.gio.loginapp.navigation.LoginAppNavHost

@Composable
fun LoginAppMain(
  composeNavigator: AppNavigator
) {
  LoginAppComposeTheme {
    val navHostController = rememberNavController()

    LaunchedEffect(Unit) {
      composeNavigator.handleNavigationCommands(navHostController)
    }

    LoginAppBackground {
      LoginAppNavHost(
        navHostController = navHostController,
        composeNavigator = composeNavigator
      )
    }
  }
}
