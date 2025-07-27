// FootbarUtil.kt
package com.bobCompany.onstarMobileApp.util

import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import com.bobCompany.onstarMobileApp.*
import com.bobCompany.onstarMobileApp.R

fun setupFootbarClicks(
    activity: Activity,
    selectedIconId: Int
) {
    val iconIds = listOf(
        R.id.imageView5,  // 빈칸
        R.id.imageView6,  // 피드
        R.id.imageView7,  // 홈
        R.id.imageView9,  // 길찾기
        R.id.imageView10  // 마이페이지
    )

    val iconViews = iconIds.mapNotNull { activity.findViewById<ImageView>(it) }

    for (icon in iconViews) {
        icon.setOnClickListener {
            val targetActivity = when (icon.id) {
                R.id.imageView5 -> LoginFragment::class.java
                R.id.imageView6 -> FeedActivity::class.java
                R.id.imageView7 -> HomeActivity::class.java
                R.id.imageView9 -> NavigateActivity::class.java
                R.id.imageView10 -> MyPageActivity::class.java
                else -> null
            }

            targetActivity?.let {
                if (activity::class.java != it) { // 현재 액티비티와 다를 때만 이동
                    val intent = Intent(activity, it)
                    activity.startActivity(intent)
                    activity.overridePendingTransition(0, 0)
                }
            }
        }

        // 선택된 아이콘 강조
        val selected = icon.id == selectedIconId
        icon.setImageResource(
            when (icon.id) {
                R.id.imageView5 -> if (selected) R.drawable.ic_sel_blank else R.drawable.ic_unsel_blank
                R.id.imageView6 -> if (selected) R.drawable.ic_sel_feed else R.drawable.ic_unsel_feed
                R.id.imageView7 -> if (selected) R.drawable.ic_sel_home else R.drawable.ic_unsel_home
                R.id.imageView9 -> if (selected) R.drawable.ic_sel_navigate else R.drawable.ic_unsel_navigate
                R.id.imageView10 -> if (selected) R.drawable.ic_sel_mypage else R.drawable.ic_unsel_mypage
                else -> R.drawable.ic_unsel_blank
            }
        )
    }
}