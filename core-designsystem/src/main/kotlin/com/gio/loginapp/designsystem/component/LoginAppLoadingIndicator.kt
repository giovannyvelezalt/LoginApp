package com.gio.loginapp.designsystem.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.gio.loginapp.designsystem.theme.BLUE450

@Composable
fun LoginAppLoadingIndicator() {
  CircularProgressIndicator(color = BLUE450)
}
