package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.bobCompany.onstarMobileApp.adapter.CardAdapter
import com.bobCompany.onstarMobileApp.data.CardItem
import com.bobCompany.onstarMobileApp.decoration.HorizontalSpaceItemDecoration


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        //이미지 슬라이더
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner_frame_mountin, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.banner_frame_geagok, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.banner_frame_sea, ScaleTypes.CENTER_CROP))

        val imageSlider = findViewById<ImageSlider>(R.id.ImageSlider)
        imageSlider.startSliding(3000)
        imageSlider.setImageList(imageList)
        //

        //도감 리스트 표시
          val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
          recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

          val items = listOf(
              CardItem(R.drawable.dogam_seoul,"서울","12 / 24"),
              CardItem(R.drawable.dogam_busan,"부산","08 / 23"),
              CardItem(R.drawable.dogam_geunggido,"경기도","03 / 36"),
              CardItem(R.drawable.dogam_jeonrado,"전라북도","23/108"),
          )


        // 도감 간격
        val spaceInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 15f,resources.displayMetrics
        ).toInt()

        recyclerView.addItemDecoration(HorizontalSpaceItemDecoration(spaceInPixels))
        //

        recyclerView.adapter = CardAdapter(items)
        //

        //도감 테마
        val recyclerViewTheme = findViewById<RecyclerView>(R.id.recyclerViewTheme)
        recyclerViewTheme.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val items_theme = listOf(
            CardItem(R.drawable.dogam_seoul,"비","12 / 24"),
            CardItem(R.drawable.dogam_busan,"안개","08 / 23"),
            CardItem(R.drawable.dogam_geunggido,"봄","03 / 36"),
            CardItem(R.drawable.dogam_jeonrado,"연인","23/108"),
        )


        // 도감 간격
        val spaceInPixels_theme = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 15f,resources.displayMetrics
        ).toInt()

        recyclerViewTheme.addItemDecoration(HorizontalSpaceItemDecoration(spaceInPixels_theme))

        recyclerViewTheme.adapter = CardAdapter(items_theme)
    }
}