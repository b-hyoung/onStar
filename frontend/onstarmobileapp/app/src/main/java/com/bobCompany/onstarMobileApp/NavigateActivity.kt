package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapSdk

class NavigateActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_navigate)

        val mapView = findViewById<MapView>(R.id.map_view)
        mapView.onCreate(savedInstanceState)

        }

    override fun onStart() {
        super.onStart()
        findViewById<MapView>(R.id.map_view).onStart()
    }

    override fun onResume() {
        super.onResume()
        findViewById<MapView>(R.id.map_view).onResume()
    }

    override fun onPause() {
        super.onPause()
        findViewById<MapView>(R.id.map_view).onPause()
    }

    override fun onStop() {
        super.onStop()
        findViewById<MapView>(R.id.map_view).onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        findViewById<MapView>(R.id.map_view).onDestroy()
    }
}
