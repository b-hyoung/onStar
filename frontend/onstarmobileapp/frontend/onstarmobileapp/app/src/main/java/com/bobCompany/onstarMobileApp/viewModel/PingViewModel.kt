package com.bobCompany.onstarMobileApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobCompany.onstarMobileApp.network_api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException

class PingViewModel : ViewModel() {
    private val _pingMessage = MutableStateFlow("로딩중...")
    val pingMessage: StateFlow<String> = _pingMessage

    init {
        fetchPing()
    }

    private fun fetchPing() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.ping().execute()
                if (response.isSuccessful) {
                    _pingMessage.value = response.body()?.message ?: "응답 없음"
                } else {
                    _pingMessage.value = "에러 코드: ${response.code()}"
                }
            } catch (e: IOException) {
                _pingMessage.value = "네트워크 에러: ${e.message}"
            } catch (e: HttpException) {
                _pingMessage.value = "서버 에러: ${e.message}"
            }
        }
    }
}
