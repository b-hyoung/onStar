package com.bobCompany.onstarMobileApp

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.graphics.Typeface
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobCompany.onstarMobileApp.adapter.FeedAdapter
import com.bobCompany.onstarMobileApp.databinding.ActivityFeedBinding
import com.bobCompany.onstarMobileApp.viewModel.FeedViewModel

class FeedActivity : AppCompatActivity(){

    private lateinit var  binding: ActivityFeedBinding
    private lateinit var adapter : FeedAdapter
    private val viewModel : FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //기본은 관광지 탭
        adapter = FeedAdapter(viewModel.tourList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        //관광지 탭 클릭
        binding.tabTour.setOnClickListener{
            adapter = FeedAdapter(viewModel.tourList)
            binding.recyclerView.adapter = adapter
            setSelectedTab(binding.tabTour)
        }

        // 음식 탭 클릭
        binding.tabFood.setOnClickListener {
            adapter = FeedAdapter(viewModel.foodList)
            binding.recyclerView.adapter = adapter
            setSelectedTab(binding.tabFood)
        }

        // 카페 탭 클릭
        binding.tabCafe.setOnClickListener {
            adapter = FeedAdapter(viewModel.cafeList)
            binding.recyclerView.adapter = adapter
            setSelectedTab(binding.tabCafe)
        }
    }

    private fun setSelectedTab(selected : TextView){
        val tabs = listOf(binding.tabTour,binding.tabFood,binding.tabCafe)
        for (tab in tabs){
            if(tab==selected){
                tab.setTypeface(null, Typeface.BOLD)
                tab.setTextColor(Color.BLACK)
            }else{
                tab.setTypeface(null,Typeface.NORMAL)
                tab.setTextColor(Color.parseColor("#999999"))
            }
        }
    }

}