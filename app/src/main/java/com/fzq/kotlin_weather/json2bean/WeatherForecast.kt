package com.fzq.kotlin_weather.json2bean

/**
 * 天气预报:最长10天天气预报数据（大客户可达14天），天气预报包含的数据：日出日落、月升月落、
 * 最高最低温度、天气白天和夜间状况、风力、风速、风向、相对湿度、大气压强、降水量、降水概率、
 * 露点温度、紫外线强度、能见度等数据
 */
class WeatherForecast (
    var heWeather6: List<HeWeather6_Forecast>
)
