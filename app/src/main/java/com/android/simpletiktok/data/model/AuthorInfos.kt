package com.android.simpletiktok.data.model

data class AuthorInfos(
    val covers: List<String>,
    val coversLarger: List<String>,
    val coversMedium: List<String>,
    val isSecret: Boolean,
    val nickName: String,
    val relation: Int,
    val roomId: String,
    val secUid: String,
    val secret: Boolean,
    val signature: String,
    val uniqueId: String,
    val userId: String,
    val verified: Boolean
)