package com.gio.loginapp.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BLUE200 = Color(0xFF90CAF9)
val BLUE300 = Color(0xFF64B5F6)
val BLUE400 = Color(0xFF42A5F5)
val BLUE450 = Color(0xFF32A5F5)
val BLUE500 = Color(0xFF2196F3)
val BLUE600 = Color(0xFF1E88E5)
val BLUE700 = Color(0xFF1976D2)

val DARK_BLUE200 = Color(0xFF232D36)
val DARK_BLUE300 = Color(0xFF101D25)

val WHITE200 = Color(0xFFe0e0e0)
val BLACK200 = Color(0xFA212020)
val GRAY100 = Color(0xC1EFF0F3)
val GRAY200 = Color(0xFF88898b)

val shimmerHighLight = Color(0xA3C2C2C2)

@Composable
fun getTabPrimaryColor(): Color {
  return if (isSystemInDarkTheme()) {
    BLUE450
  } else {
    WHITE200
  }
}

@Composable
fun getTitleColor(): Color {
  return if (isSystemInDarkTheme()) {
    WHITE200
  } else {
    BLACK200
  }
}
