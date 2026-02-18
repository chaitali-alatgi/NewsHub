package com.example.newshub.di

import com.example.newshub.core.cache.NewsCacheManager
import com.example.newshub.data.local.NewsCacheDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsCacheManager(
        cache: Cache,
        newsCacheDao: NewsCacheDao,
    ): NewsCacheManager = NewsCacheManager(cache, newsCacheDao)
}