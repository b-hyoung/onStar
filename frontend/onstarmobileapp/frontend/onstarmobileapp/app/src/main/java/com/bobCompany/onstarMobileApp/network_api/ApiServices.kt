package com.bobCompany.onstarMobileApp.network_api

import com.bobCompany.onstarMobileApp.data.PingResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api")
    fun ping(): Call<PingResponse>
}