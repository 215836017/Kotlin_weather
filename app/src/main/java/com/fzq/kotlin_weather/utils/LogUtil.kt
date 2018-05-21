package com.fzq.kotlin_weather.utils

import android.util.Log

/**
 * 控制是否打印全局log的标志
 */
var isPrintLog: Boolean = true

/**
 * 一个简单的全局打印log的函数, 使用 Log.i()
 */
fun printLog(tag: String, msg: String) {
    if (isPrintLog) {
        var tag1 = tag
        if(tag.length >= 23){
            tag1 = tag.substring(0, 23)
        }
        Log.i(tag1, "Global_log-- $msg")
    }
}

/**
 * 一个简单的全局打印log的函数, 使用 Log.e()
 */
fun printErrorLog(tag: String, msg: String){
    if(isPrintLog){
        var tag1 = tag
        if(tag.length >= 23){
            tag1 = tag.substring(0, 23)
        }

        Log.e(tag1, "Global_errorLog-- $msg")
    }
}