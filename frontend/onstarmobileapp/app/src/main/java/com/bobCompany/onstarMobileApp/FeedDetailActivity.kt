package com.bobCompany.onstarMobileApp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bobCompany.onstarMobileApp.databinding.ActivityFeedDetailBinding
import com.bobCompany.onstarMobileApp.util.setupFootbarClicks
import com.bobCompany.onstarMobileApp.viewModel.FeedViewModel

class FeedDetailActivity :AppCompatActivity() {

    private lateinit var binding : ActivityFeedDetailBinding
    private val viewModel = FeedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityFeedDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFootbarClicks(this,R.id.imageView6)

        val feedId = intent.getIntExtra("feed_id",-1)

        val item = (viewModel.tourList + viewModel.foodList + viewModel.cafeList)
            .find{it.id == feedId}

        item?.let {
            binding.title.text = it.title
            binding.address.text = it.address
            binding.subaddress.text=it.subAddress
            binding.date.text = "Date ${it.date}"
            binding.description.text = it.description
            binding.setimageResource.setImageResource(it.imageResId)
            binding.likeCount.text = it.likeCount.toString()
            binding.viewCount.text = it.viewCount.toString()
        }

        val otherPosts = (viewModel.tourList + viewModel.foodList + viewModel.cafeList)
            .filter{ it.id != feedId}
            .take(3)

        for (post in otherPosts){
            val card = layoutInflater.inflate(R.layout.item_other_post,binding.otherPostContainer,false)

            val image = card.findViewById<ImageView>(R.id.otherImage)
            val title = card.findViewById<TextView>(R.id.otherTitle)
            val like = card.findViewById<TextView>(R.id.otherLike)
            val view = card.findViewById<TextView>(R.id.otherView)

            image.setImageResource(post.imageResId)
            title.text = post.title
            like.text = post.likeCount.toString()
            view.text = post.viewCount.toString()


            //클릭 시 다른 페이지 이동
            card.setOnClickListener({
                val intent = Intent(this,FeedDetailActivity::class.java)
                intent.putExtra("feed_id",post.id)
                startActivity(intent)
                finish() // 이전 엑티비티 종료
            })

            binding.otherPostContainer.addView(card)
        }

    }

}