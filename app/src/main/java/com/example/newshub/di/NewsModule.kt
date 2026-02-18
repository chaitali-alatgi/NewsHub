package com.example.newshub.di

import android.content.Context
import com.google.gson.Gson
import com.example.newshub.core.cache.NewsCacheManager
import com.example.newshub.data.datasource.NewsLocalDataSource
import com.example.newshub.data.datasource.NewsRemoteDataSource
import com.example.newshub.data.local.TopicDao
import com.example.newshub.data.repository.NewsRepository
import com.example.newshub.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object NewsModule {

    @Provides
    @ActivityRetainedScoped
    fun provideNewsRepository(
        remoteDataSource: NewsRemoteDataSource,
        localDataSource: NewsLocalDataSource,
        topicDao: TopicDao,
        newsCacheManager: NewsCacheManager
    ): NewsRepository = NewsRepositoryImpl(
        remoteDataSource = remoteDataSource,
        localDataSource = localDataSource,
        topicDao = topicDao,
        newsCacheManager = newsCacheManager
    )

    @Provides
    @ActivityRetainedScoped
    fun provideNewsLocalDataSource(
        @ApplicationContext context: Context,
        topicDao: TopicDao,
        gson: Gson
    ): NewsLocalDataSource = NewsLocalDataSource(context, topicDao, gson)

    @Provides
    @ActivityRetainedScoped
    fun provideNewsRemoteDataSource(
        retrofit: Retrofit,
        gson: Gson
    ): NewsRemoteDataSource = NewsRemoteDataSource(retrofit, gson)
}