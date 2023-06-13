package com.hamtary.myapplication.di

import android.content.Context
import com.hamtary.myapplication.data.local.DataStoreManager
import com.hamtary.myapplication.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//    @Provides
//    @Singleton
//    fun provideAuthRepo(apiService: ApiService): AuthRepository = AuthRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun dataStoreManager(@ApplicationContext context: Context): DataStoreManager = DataStoreManager(context)

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context) = context
}