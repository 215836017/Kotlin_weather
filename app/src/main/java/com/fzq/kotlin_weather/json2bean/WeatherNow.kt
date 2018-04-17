package com.fzq.kotlin_weather.json2bean

/**
 * 实况天气: 即为当前时间点的天气状况以及温湿风压等气象指数，具体包含的数据：体感温度、实测温度、
 * 天气状况、风力、风速、风向、相对湿度、大气压强、降水量、能见度等。
 */
class WeatherNow (

    var heWeather6: List<HeWeather6_Forecast>
)