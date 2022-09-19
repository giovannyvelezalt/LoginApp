@file:OptIn(ExperimentalSerializationApi::class)

package com.gio.loginapp.network.di

import com.gio.loginapp.network.service.LoginAppUserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun providesNetworkJson(): Json = Json {
    ignoreUnknownKeys = true
  }

  @Provides
  @Singleton
  fun provideRetrofit(networkJson: Json): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client: OkHttpClient = OkHttpClient.Builder()
      .addInterceptor(interceptor)
      .build()

    return Retrofit.Builder()
      .baseUrl("https://gist.githubusercontent.com/giovannyvelezalt/977222c95645fa89c36e7b35a2f84251/raw/da16b9d7f08a2ee129c4200a689b2362fd0d2b5c/")
      .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
      .client(client)
      .build()
  }

  @Provides
  @Singleton
  fun provideLoginAppUserService(retrofit: Retrofit): LoginAppUserService {
    return retrofit.create()
  }
}
