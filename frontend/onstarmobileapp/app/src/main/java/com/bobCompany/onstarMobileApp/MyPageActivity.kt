package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bobCompany.onstarMobileApp.util.setupFootbarClicks

class MyPageActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_mypage)
        setupFootbarClicks(this,R.id.imageView10)

        //통계
        val menuStats = findViewById<View>(R.id.menu_stats)
        menuStats.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_mypage_data)
        menuStats.findViewById<TextView>(R.id.title).text="내 통계"

        //나의 취향 분석
        val menuLike = findViewById<View>(R.id.menu_like)
        menuLike.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_mypage_like)
        menuLike.findViewById<TextView>(R.id.title).text="나의 취향 분석(Ai Beta)"

        //내가 저장한 장소
        val menuLocation = findViewById<View>(R.id.menu_location)
        menuLocation.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_mypage_savelocation)
        menuLocation.findViewById<TextView>(R.id.title).text="내가 저장한 장소"

        // 설정
        val menuSetting = findViewById<View>(R.id.menu_setting)
        menuSetting.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_mypage_setting)
        menuSetting.findViewById<TextView>(R.id.title).text="설정"

        //문의하기
        val menuContact = findViewById<View>(R.id.menu_contact)
        menuContact.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_mypage_ask)
        menuContact.findViewById<TextView>(R.id.title).text="문의하기"
    }

}