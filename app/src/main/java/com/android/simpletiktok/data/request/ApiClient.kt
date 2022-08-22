package com.android.simpletiktok.data.request

import com.android.simpletiktok.util.Constants
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

class ApiClient {
    private val client = OkHttpClient()

    fun makeApiRequest(): Call {
        val request = Request.Builder()
            .url(Constants.BASE_URL)
            .build()

        return client.newCall(request)
    }
}