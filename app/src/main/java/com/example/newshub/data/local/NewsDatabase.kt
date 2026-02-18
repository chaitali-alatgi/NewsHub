package com.example.newshub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newshub.data.model.NewsCache
import com.example.newshub.data.model.Topic

@Database(entities = [Topic::class, NewsCache::class], version = 2)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun newsCacheDao(): NewsCacheDao
}