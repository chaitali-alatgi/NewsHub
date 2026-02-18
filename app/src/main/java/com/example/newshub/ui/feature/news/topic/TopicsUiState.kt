package com.example.newshub.ui.feature.news.topic

import com.example.newshub.data.model.Topic

data class TopicsUiState(
    val topics: List<Topic> = listOf(),
    val selectedTopic: String = ""
)