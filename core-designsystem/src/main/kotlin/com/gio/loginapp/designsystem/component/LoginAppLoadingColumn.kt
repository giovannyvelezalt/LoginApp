package com.gio.loginapp.designsystem.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun LoginAppLoadingColumn(
    itemSize: Int = 10
) {
    LazyColumn {
        items(itemSize) {
        }
    }
}