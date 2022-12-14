package com.android.simpletiktok.data.model

data class ItemInfos(
    val authorId: String,
    val commentCount: Int,
    val commentStatus: Int,
    val covers: List<String>,
    val coversDynamic: List<String>,
    val coversOrigin: List<String>,
    val createTime: String,
    val diggCount: Int,
    val forFriend: Boolean,
    val id: String,
    val isActivityItem: Boolean,
    val isAd: Boolean,
    val isOfficial: Boolean,
    val isOriginal: Boolean,
    val itemMute: Boolean,
    val liked: Boolean,
    val musicId: String,
    val playCount: Int,
    val secret: Boolean,
    val shareCount: Int,
    val shareCover: List<String>,
    val shareEnabled: Boolean,
    val showNotPass: Boolean,
    val stitchEnabled: Boolean,
    val text: String,
    val video: Video,
    val vl1: Boolean,
    val warnInfo: List<Any>
)