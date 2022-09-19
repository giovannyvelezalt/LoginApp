package com.gio.loginapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gio.loginapp.database.entity.LoginAppUserEntity

@Dao
interface LoginAppUserDao {

  @Query(value = "SELECT * FROM users")
  suspend fun getLoginAppUsers(): List<LoginAppUserEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertLoginAppUsers(loginAppUsers: List<LoginAppUserEntity>)
}
