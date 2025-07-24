package com.bobCompany.onstarMobileApp.viewModel

import androidx.lifecycle.ViewModel
import com.bobCompany.onstarMobileApp.R
import com.bobCompany.onstarMobileApp.data.FeedItem

class FeedViewModel : ViewModel() {
    val tourList = listOf(
        FeedItem(
            id = 1,
            title = "춘향루 달빛바다",
            address = "전라남도 남원시",
            subAddress = "춘향로 몽룡리 131-2",
            date = "25.04.02",
            tag1 = "춘향루",
            tag2 = "남원",
            likeCount = 65,
            viewCount = 132,
            imageResId = R.drawable.feed_banner_namwon,
            hashtags = listOf("야경 맛집","축제 맛집","10CM","그라데이션"),
            description = "남원에 오시면 춘향루로오세요.\n밤에 걷는 춘향루 거리가 좋아요"
        ),
        FeedItem(
            id = 2,
            title = "오동도 김밥",
            address = "전라남도 여수시",
            subAddress = "오동면 오동로 131-2",
            date = "25.04.01",
            tag1 = "오동도",
            tag2 = "여수",
            likeCount = 32,
            viewCount = 88,
            imageResId = R.drawable.feed_banner_odongdo,
            hashtags = listOf("김밥맛집","여수오면","꼭가보세요!","여수밤바다"),
            description = "여수에 오동도 김밥맛있어요.\n와서 다들 꼭 드셔보세요"
        )
    )

    val foodList = listOf(
            FeedItem(
                id = 3,
                title = "서울의 봄",
                address = "서울 특별시",
                subAddress = "해상길 상상로 32-1",
                date = "25.04.01",
                tag1 = "상상길",
                tag2 = "서울",
                likeCount = 79,
                viewCount = 88,
                imageResId = R.drawable.dogam_seoul,
                hashtags = listOf("봄맛집","서울풍경","꼭가보세요!","그댄바람바람바람"),
                description = "서울의 봄봄봄 봄이왔네요\n우리가 처음만났던 그때 향기그대로"
            )
        )

    val cafeList = listOf(
        FeedItem(
            id = 4,
            title = "부산은 해운대",
            address = "경상도 부산",
            subAddress = "해운로 해운길 12-1",
            date = "25.04.02",
            tag1 = "해운대",
            tag2 = "부산",
            likeCount = 121,
            viewCount = 203,
            imageResId = R.drawable.dogam_busan,
            hashtags = listOf("야경 맛집","해수욕장","다리길다","뿌에에엑"),
            description = "부산 부산 아름다운이거리\n부산 부산 해운대로오세유 길게쓰면 얼마나 길게 적힐지 많이적으면 어떻게될까요오오오오오오오 하지만 20자로 제한할꺼긴해요"
        )
    )
}