package com.gio.loginapp.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkLoginAppColorScheme = darkColorScheme(
  primary = DARK_BLUE200,
  primaryContainer = DARK_BLUE300,
  secondary = BLUE500,
  background = DARK_BLUE300,
  tertiary = WHITE200,
  onTertiary = GRAY200
)

private val LightLoginAppColorScheme = lightColorScheme(
  primary = BLUE500,
  primaryContainer = BLUE700,
  secondary = BLUE300,
  background = WHITE200,
  tertiary = WHITE200,
  onTertiary = GRAY200
)

/** Light Android background theme */
private val LightAndroidBackgroundTheme = BackgroundTheme(color = Color.White)

/** Dark Android background theme */
private val DarkAndroidBackgroundTheme = BackgroundTheme(color = DARK_BLUE300)

@Composable
fun LoginAppComposeTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme = if (darkTheme) DarkLoginAppColorScheme else LightLoginAppColorScheme
  val backgroundTheme = if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme

  CompositionLocalProvider(
    LocalBackgroundTheme provides backgroundTheme
  ) {
    MaterialTheme(
      colorScheme = colorScheme,
      typography = Typography,
      content = content
    )
  }
}
