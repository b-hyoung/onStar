package com.bobCompany.onstarMobileApp.data

data class FeedItem(
    val id: Int ,
    val title : String,
    val address : String,
    val subAddress : String,
    val date : String,
    val tag1: String,
    val tag2: String,
    val likeCount: Int,
    val viewCount: Int,
    val imageResId: Int,
    val hashtags: List<String>,//해시태그 추가
    val description : String // 설명
)