package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.overlay.LocationOverlay

class NavigateActivity : AppCompatActivity() , OnMapReadyCallback  {

    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap
    private lateinit var locationSource : FusedLocationSource

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE  = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_navigate)

        //드롭다운 스피너 연결
        val spinner = findViewById<Spinner>(R.id.area_spinner)

        // 지역 리스트
        val areaList = resources.getStringArray(R.array.area_list)

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,     // 커스텀 레이아웃 적용
            areaList
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // 드롭다운은 기본 사용
        spinner.adapter = adapter
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        // 드롭다운을 아래로 약간 더 띄워줌
        spinner.dropDownVerticalOffset = 120
        spinner.dropDownHorizontalOffset = 0

        mapView = findViewById<MapView>(R.id.map_view)
        mapView.onCreate(savedInstanceState)

        //위치 소스 생성
        locationSource  = FusedLocationSource(this,LOCATION_PERMISSION_REQUEST_CODE)

        //지도 비동기 준비
        mapView.getMapAsync(this)

        // 내 위치 버튼
        val myLocationContainer = findViewById<LinearLayout>(R.id.my_location_container)
        myLocationContainer.setOnClickListener {
            naverMap.locationTrackingMode = LocationTrackingMode.Follow
        }
        }


    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap

        // 4. 위치 권한 설정
        naverMap.locationSource = locationSource

        // 5. 현재 위치 추적 모드 설정
        naverMap.locationTrackingMode = LocationTrackingMode.None

        // 6. 위치 오버레이 표시 (파란 점)
        val locationOverlay: LocationOverlay = naverMap.locationOverlay
        locationOverlay.isVisible = true

        //기본 위치 설정
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.5665, 126.9780))
        naverMap.moveCamera(cameraUpdate)
    }

    // 7. 권한 요청 처리
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (::locationSource.isInitialized) {
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
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
