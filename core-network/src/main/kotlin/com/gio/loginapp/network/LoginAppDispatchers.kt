package com.gio.loginapp.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val loginAppDispatchers: LoginAppDispatchers)

enum class LoginAppDispatchers {
  IO
}
