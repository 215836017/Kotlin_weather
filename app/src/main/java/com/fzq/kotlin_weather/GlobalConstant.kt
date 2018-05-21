package com.fzq.kotlin_weather

import android.content.Context
import android.content.SharedPreferences

//保存 全局常量/变量 的文件

/**
 * 和风API的baseUrl
 */
val baseUrl = "https://free-api.heweather.com/s6/weather/"

/**
 * 和风API的key
 */
val heFeng_key: String  = "458c682400df47efb841a69154d7677d "
/**
 * 用户名
 */
val userName = "HE1804141148361464"

/**
 * 默认的location，
 */
var defaultLocation = "hangzhou"

/**
 *  用来初始化SharedPreferences的变量
 */
val sp_name = "kotlin_weather_spName"

object SharedPreferenceUtil {
    fun initSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(sp_name, Context.MODE_PRIVATE)
    }

    fun inisEditor(context: Context): SharedPreferences.Editor {
        return initSharedPreferences(context).edit()
    }
}

//********************* 保存在sp中内容的字段 -- start *************************
val SP_LAST_LOCATION: String = "sp_last_location"
//********************* 保存在sp中内容的字段 -- end ***************************

