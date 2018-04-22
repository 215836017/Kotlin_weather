package com.fzq.kotlin_weather.json2bean.hourly

import com.fzq.kotlin_weather.json2bean.*

data class HeWeather6(val basic: Basic, val hourly: List<Hourly>, val status: String,
                      val update: Update)