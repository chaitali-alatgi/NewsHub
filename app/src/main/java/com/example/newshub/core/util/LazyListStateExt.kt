package com.example.newshub.core.util

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.isListAtTop() =
    firstVisibleItemIndex == 0 && firstVisibleItemScrollOffset == 0