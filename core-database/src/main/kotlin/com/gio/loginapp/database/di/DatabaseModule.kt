package com.gio.loginapp.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.gio.loginapp.database.LoginAppDataBase
import com.gio.loginapp.database.dao.LoginAppUserDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  @Provides
  @Singleton
  fun provideLoginAppCloneDatabase(
    @ApplicationContext context: Context
  ): LoginAppDataBase = Room.databaseBuilder(
    context,
    LoginAppDataBase::class.java,
    "loginapp-database"
  ).build()

  @Provides
  @Singleton
  fun provideLoginAppUserDao(
    loginAppCloneDataBase: LoginAppDataBase
  ): LoginAppUserDao {
    return loginAppCloneDataBase.loginAppUserDao()
  }
}
