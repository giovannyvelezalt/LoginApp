package com.gio.loginapp.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector

object LoginAppIcons {
  val ArrowBack = Icons.Rounded.ArrowBack
  val Camera = Icons.Default.CameraAlt
  val Message = Icons.Filled.Message
  val Search = Icons.Default.Search
  var MoreVert = Icons.Default.MoreVert
  var Call = Icons.Filled.Call
  var Video = Icons.Filled.VideoCall
  var Mic = Icons.Filled.Mic
  var PeopleAlt = Icons.Filled.PeopleAlt
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
  data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
  data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
