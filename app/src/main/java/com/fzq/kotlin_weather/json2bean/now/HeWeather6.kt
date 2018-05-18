package com.fzq.kotlin_weather.json2bean.now

import com.fzq.kotlin_weather.json2bean.*
import java.io.Serializable
data class HeWeather6(val basic: Basic, val now: Now, val status: String, val update: Update) : Serializable
