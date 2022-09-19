package com.gio.loginapp.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.gio.loginapp.data.repository.UserRepository
import com.gio.loginapp.data.repository.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

  @Binds
  fun bindsUserRepository(
    userRepositoryImpl: UserRepositoryImpl
  ): UserRepository
}
