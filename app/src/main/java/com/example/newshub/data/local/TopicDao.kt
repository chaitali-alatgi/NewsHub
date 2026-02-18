package com.example.newshub.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newshub.data.model.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topics")
    suspend fun getAllTopics(): List<Topic>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(topic: List<Topic>)

    @Query("DELETE FROM topics")
    suspend fun deleteAll()
}