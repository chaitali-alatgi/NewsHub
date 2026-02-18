package com.example.newshub.core.network

import com.example.newshub.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-rapidapi-host", "news-api14.p.rapidapi.com")
                // set your api key here
                .addHeader("x-rapidapi-key", BuildConfig.API_KEY)
                .build()
        )
}