package com.android.simpletiktok.data.model

data class MusicInfos(
    val authorName: String,
    val covers: List<String>,
    val coversLarger: List<String>,
    val coversMedium: List<String>,
    val musicId: String,
    val musicName: String,
    val original: String,
    val playUrl: List<String>
)