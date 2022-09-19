package com.gio.loginapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gio.loginapp.database.dao.LoginAppUserDao
import com.gio.loginapp.database.entity.LoginAppUserEntity

@Database(
  entities = [LoginAppUserEntity::class],
  version = 1,
  exportSchema = true
)
abstract class LoginAppDataBase : RoomDatabase() {
  abstract fun loginAppUserDao(): LoginAppUserDao
}
