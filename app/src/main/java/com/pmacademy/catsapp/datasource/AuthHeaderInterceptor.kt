package com.pmacademy.catsapp.datasource

import okhttp3.Interceptor
import okhttp3.Response

class AuthHeaderInterceptor : Interceptor {

    private companion object {
        const val CAT_API_KEY = "a12d98e3-e32f-4b24-9b09-0605bfd94688"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("x-api-key", CAT_API_KEY)
                .build()
        )
    }
}
