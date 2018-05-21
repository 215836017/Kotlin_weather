package com.fzq.kotlin_weather.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * 根据日期获取星期
 */
fun getWeekDay(date: String): String {
    val calendar: Calendar = Calendar.getInstance()
    val format = SimpleDateFormat("yyyy-MM-dd")
    calendar.time = format.parse(date)
    var result = ""
    when (calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> result = "SUN"
        2 -> result = "MON"
        3 -> result = "TUE"
        4 -> result = "WED"
        5 -> result = "THU"
        6 -> result = "FRI"
        7 -> result = "SAT"
        else -> result = ""

    }
    return result

}