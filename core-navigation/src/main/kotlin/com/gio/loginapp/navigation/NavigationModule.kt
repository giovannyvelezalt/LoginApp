package com.gio.loginapp.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

  @Binds
  @Singleton
  abstract fun provideComposeNavigator(loginAppCloneComposeNavigator: LoginAppNavigator): AppNavigator
}
