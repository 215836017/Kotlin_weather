package com.fzq.kotlin_weather

import android.content.Context
import android.content.SharedPreferences

//保存 全局常量/变量 的文件

/**
 *  用来初始化SharedPreferences的变量
 */
val sp_name = "kotlin_weather_spName"

fun initSharedPreferences(context: Context): SharedPreferences{
    return context.getSharedPreferences(sp_name, Context.MODE_PRIVATE)
}

fun inisEditor(context: Context): SharedPreferences.Editor{
    return initSharedPreferences(context).edit()
}


//********************* 保存在sp中内容的字段 -- start *************************
val SP_LAST_LOCATION: String = "sp_last_location"
//********************* 保存在sp中内容的字段 -- end ***************************

