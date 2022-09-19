package com.gio.loginapp.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gio.loginapp.data.repository.UserRepository
import com.gio.loginapp.model.LoginAppUser
import com.gio.loginapp.network.Dispatcher
import com.gio.loginapp.network.LoginAppDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LoginAppViewModel @Inject constructor(
    private val loginUserRepository: UserRepository,
    @Dispatcher(LoginAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val loginAppUserState: MutableStateFlow<LoginAppUiState> = MutableStateFlow(LoginAppUiState.NonLogged)
    val snackBarMessage = MutableStateFlow("")

    fun login(user: String, passwd: String) {
        println("LOGIN")

        viewModelScope.launch(ioDispatcher) {
            println("LOGIN inside vmScope")

            loginUserRepository.getUser(user, passwd).also {
                if (it.isSuccess) {
                    println("SUCCESS ${it.getOrThrow().login}")

                    loginAppUserState.emit(LoginAppUiState.Success(it.getOrThrow()))
                } else {
                    println("FAILURE")
                    loginAppUserState.emit(LoginAppUiState.Error)
                }
            }
        }
    }

    fun setSnackbarMsg(text: String) {snackBarMessage.value = text}
    fun setUserState(state: LoginAppUiState) {loginAppUserState.value = state}
}

sealed interface LoginAppUiState {
    data class Success(val loginAppUser: LoginAppUser) : LoginAppUiState
    object Error : LoginAppUiState
    object Loading : LoginAppUiState
    object NonLogged : LoginAppUiState
}
