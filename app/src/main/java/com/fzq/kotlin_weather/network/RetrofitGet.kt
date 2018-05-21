package com.fzq.kotlin_weather.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RetrofitGet {

    // https://free-api.heweather.com/s6/weather/forecast?parameters
    @GET("forecast")
    fun queryWeatherForecast(@QueryMap map: Map<String, String>): Call<ResponseBody>


    // https://free-api.heweather.com/s6/weather/now?parameters
    @GET("now")
    fun queryWeatherNow(@Query("location") location: String, @Query("key") key: String): Call<ResponseBody>

    // https://free-api.heweather.com/s6/weather/hourly?parameters
    @GET("hourly")
    fun queryWeahterHourly(@QueryMap map: Map<String, String>): Call<ResponseBody>
}