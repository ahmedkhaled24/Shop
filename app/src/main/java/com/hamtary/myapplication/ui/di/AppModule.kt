package com.hamtary.myapplication.ui.di

import com.hamtary.myapplication.data.remote.StoreApiInterface
import com.hamtary.myapplication.data.repository.StoreApiRepoImpl
import com.hamtary.myapplication.domain.repository.StoreApIRepo
import com.hamtary.myapplication.utils.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStoreApiInterface(): StoreApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoreApiInterface::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataPort {
    @Binds
    @Singleton
    abstract fun bindStoreApiRepo(impl: StoreApiRepoImpl): StoreApIRepo
}
