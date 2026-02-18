package com.example.newshub.core.util

import java.util.concurrent.TimeUnit

fun TimeUnit.fromMs(ms: Long): Long = convert(ms, TimeUnit.MILLISECONDS)