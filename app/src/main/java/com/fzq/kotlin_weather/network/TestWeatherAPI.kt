package com.fzq.kotlin_weather.network

import android.util.Log
import java.net.URL

fun getWeatherForecast(path: String): String{

    val response = URL(path).readText()
    //打印返回的json格式数据
    println("返回的json数据：\n" + response)
    Log.i("return-json", response)
    return response

}
