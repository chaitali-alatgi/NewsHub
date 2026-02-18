package com.example.newshub.data.datasource

import com.example.newshub.core.network.ApiResult
import com.example.newshub.data.model.Country
import com.example.newshub.data.model.NewsResult
import com.example.newshub.data.model.Topic

interface NewsDataSource {
    suspend fun getSupportedTopics(): ApiResult<List<Topic>>
    suspend fun getTrendingNews(
        topic: String,
        language: String,
        // set the default value to null because this is optional query param
        page: Int? = null,
        country: String? = null
    ): ApiResult<NewsResult>
    suspend fun getSupportedCountries(): ApiResult<Map<String, Country>>
}