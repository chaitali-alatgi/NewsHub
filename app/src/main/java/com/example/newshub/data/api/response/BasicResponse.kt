package com.example.newshub.data.api.response

data class BasicResponse<T>(val success: Boolean, val data: T)