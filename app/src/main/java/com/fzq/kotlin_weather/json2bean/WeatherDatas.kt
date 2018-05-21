package com.fzq.kotlin_weather.json2bean

import java.util.*
import java.io.Serializable

// weather/forecast -- 3-10天天气预报
data class WeatherForecast(val HeWeather6: MutableList<com.fzq.kotlin_weather.json2bean.forecast.HeWeather6>)

data class Daily_forecast(val cond_code_d: String, val cond_code_n: String, val cond_txt_d: String,
                          val cond_txt_n: String, val date: String, val hum: String, val pcpn: String, val pop: String,
                          val pres: String, val tmp_max: String, val tmp_min: String, val uv_index: String,
                          val vis: String, val wind_deg: String, val wind_dir: String, val wind_sc: String,
                          val wind_spd: String)

// weather/now -- 实时天气
data class WeatherNow(val HeWeather6: MutableList<com.fzq.kotlin_weather.json2bean.now.HeWeather6>) : Serializable

data class Basic(val cid: String, val location: String, val parent_city: String, val admin_area: String,
                 val cnty: String, val lat: String, val lon: String, val tz: String) : Serializable

data class Now(val cond_code: String, val cond_txt: String, val fl: String, val hum: String,
               val pcpn: String, val pres: String, val tmp: String, val vis: String, val wind_deg: String,
               val wind_dir: String, val wind_sc: String, val wind_spd: String) : Serializable

data class Update(val loc: String, val utc: String) : Serializable

// weather/hourly  ---  逐小时预报
data class WeatherHourly(val HeWeather6: MutableList<com.fzq.kotlin_weather.json2bean.hourly.HeWeather6>)

data class Hourly(val cloud: String, val cond_code: String, val cond_txt: String, val hum: String,
                  val pop: String, val pres: String, val time: String, val tmp: String,
                  val wind_deg: String, val wind_dir: String, val wind_sc: String,
                  val wind_spd: String)