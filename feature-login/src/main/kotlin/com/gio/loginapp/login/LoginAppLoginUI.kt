package com.gio.loginapp.login

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gio.loginapp.designsystem.component.LoginAppLoadingColumn
import com.gio.loginapp.navigation.AppNavigator

@Composable
fun LoginAppLogin(
    composeNavigator: AppNavigator,
    loginAppViewModel: LoginAppViewModel
) {
    val snackbarHostState = SnackbarHostState()

    val loginAppUserUiState by loginAppViewModel.loginAppUserState.collectAsState()
    val snackMessage by loginAppViewModel.snackBarMessage.collectAsStateWithLifecycle("")

    LoginPage { _user, _pass ->
        loginAppViewModel.login(_user, _pass)
    }

    LoginAppScreen(
        composeNavigator = composeNavigator,
        loginAppUsersUiState = loginAppUserUiState,
        loginAppViewModel = loginAppViewModel
    )

    SnackbarHost(hostState = snackbarHostState)

    LaunchedEffect(snackMessage) {
        if (snackMessage.isNotEmpty()) {
            println("NOT EMPTY [$snackMessage]")
            snackbarHostState.showSnackbar(snackMessage)
            loginAppViewModel.setSnackbarMsg("")
        }
    }
}

@Composable
private fun LoginAppScreen(
    composeNavigator: AppNavigator,
    loginAppUsersUiState: LoginAppUiState,
    loginAppViewModel: LoginAppViewModel
) {
    when (loginAppUsersUiState) {
        LoginAppUiState.Loading -> LoginAppLoadingColumn()
        LoginAppUiState.Error -> {
            loginAppViewModel.setSnackbarMsg(
                "No User Logged In"
            )
            loginAppViewModel.setUserState(LoginAppUiState.NonLogged)
        }
        //LoginAppError()
        is LoginAppUiState.Success -> {
            loginAppViewModel.setSnackbarMsg(
                "Logged In User " +
                        "${loginAppUsersUiState.loginAppUser.login}"
            )
            loginAppViewModel.setUserState(LoginAppUiState.NonLogged)
        }
        LoginAppUiState.NonLogged -> {
        }
    }
}