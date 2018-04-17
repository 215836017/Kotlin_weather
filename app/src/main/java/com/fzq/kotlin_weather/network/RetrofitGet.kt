package com.fzq.kotlin_weather.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitGet {

    @GET("now?location=hangzhou&key=458c682400df47efb841a69154d7677d")
    fun getCall(): Call<ResponseBody>
}