package com.gio.loginapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gio.loginapp.R
import com.gio.loginapp.designsystem.icon.LoginAppIcons
import com.gio.loginapp.designsystem.theme.LoginAppComposeTheme

@Composable
fun LoginAppTopBar() {
  TopAppBar(
    modifier = Modifier.fillMaxWidth(),
    backgroundColor = MaterialTheme.colorScheme.primary,
    elevation = 0.dp
  ) {
    Row(
      modifier = Modifier
        .wrapContentWidth()
        .padding(12.dp)
    ) {
      Text(
        text = stringResource(id = R.string.app_name),
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.titleLarge
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
      ) {
        Icon(
          modifier = Modifier.size(26.dp),
          imageVector = LoginAppIcons.Search,
          tint = MaterialTheme.colorScheme.tertiary,
          contentDescription = null
        )

        Spacer(modifier = Modifier.size(16.dp))

        Icon(
          modifier = Modifier.size(26.dp),
          imageVector = LoginAppIcons.MoreVert,
          tint = MaterialTheme.colorScheme.tertiary,
          contentDescription = null
        )
      }
    }
  }
}

@Preview
@Composable
private fun LoginAppTopBarPreview() {
  LoginAppComposeTheme {
    LoginAppTopBar()
  }
}

@Preview
@Composable
private fun LoginAppTopBarDarkPreview() {
  LoginAppComposeTheme(darkTheme = true) {
    LoginAppTopBar()
  }
}
