package com.android.simpletiktok.data.model

data class ChallengeInfo(
    val challengeId: String,
    val challengeName: String,
    val covers: List<String>,
    val coversLarger: List<String>,
    val coversMedium: List<String>,
    val isCommerce: Boolean,
    val splitTitle: String,
    val text: String
)