package com.android.simpletiktok.data.model

data class Body(
    val hasMore: Boolean,
    val itemABParams: List<Any>,
    val itemListData: ArrayList<ItemData>,
    val maxCursor: String,
    val minCursor: String,
    val pageState: PageState,
    val statusCode: Int
)