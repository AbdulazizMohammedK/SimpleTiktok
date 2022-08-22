package com.android.simpletiktok.data.model

data class PageState(
    val appType: String,
    val baseURL: String,
    val fullUrl: String,
    val os: String,
    val region: String,
    val regionAppId: Int
)