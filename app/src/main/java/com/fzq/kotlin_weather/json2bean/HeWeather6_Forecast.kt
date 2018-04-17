package com.fzq.kotlin_weather.json2bean

class HeWeather6_Forecast(
    var basic: Basic,
    var daily_forecast: List<Daily_forecast>,
    var status: String,
    var update: Update
)
