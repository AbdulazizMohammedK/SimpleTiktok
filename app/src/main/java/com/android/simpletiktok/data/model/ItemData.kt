package com.android.simpletiktok.data.model

data class ItemData(
    val authorInfos: AuthorInfos,
    val authorStats: AuthorStats,
    val challengeInfoList: List<ChallengeInfo>,
    val duetInfo: String,
    val itemInfos: ItemInfos,
    val musicInfos: MusicInfos,
    val stickerTextList: List<Any>,
    val textExtra: List<TextExtra>
)