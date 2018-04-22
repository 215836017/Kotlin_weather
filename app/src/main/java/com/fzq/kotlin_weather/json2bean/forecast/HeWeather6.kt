package com.fzq.kotlin_weather.json2bean.forecast

import com.fzq.kotlin_weather.json2bean.*

data class HeWeather6(val basic: Basic, val daily_forecast: List<Daily_forecast>,
                      val status: String, val update: Update)