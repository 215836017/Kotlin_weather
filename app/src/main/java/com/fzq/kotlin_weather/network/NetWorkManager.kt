package com.fzq.kotlin_weather.network;

import com.fzq.kotlin_weather.json2bean.Basic
import com.fzq.kotlin_weather.json2bean.WeatherForecast

class NetWorkManager {

    companion object {
        private fun serviceEndPoint(): String{
            return "https://free-api,heweather.com/s6/"
        }

        private val weatherURL = serviceEndPoint() + ""
    }

}
