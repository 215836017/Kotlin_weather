package com.fzq.kotlin_weather.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager

/**
 * 判断是否有网络连接
 */
fun isNetworkConnected(context: Context): Boolean {
    if (null != context) {
        val connManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connManager.activeNetworkInfo

        if (null != networkInfo) {
            return networkInfo.isAvailable
        }
    }

    return false
}

/**
 * 判断WIFI网络是否开启
 */
fun isWifiOpen(context: Context): Boolean {

    if (null != context) {
        val wifiManger: WifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (null != wifiManger && wifiManger.isWifiEnabled) {
            return true
        }
    }

    return false
}

/**
 * 判断WIFI网络是否可用
 */
fun isWifiConnected(context: Context): Boolean {
    if (null != context) {
        val connManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        val networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (null != networkInfo) {
            return networkInfo.isAvailable
        }
    }

    return false
}

/**
 * 判断MOBILE网络是否可用
 */
fun isMobileConnected(context: Context): Boolean{

    if(null != context){
        val connManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        val networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if(null != networkInfo){
            return networkInfo.isAvailable
        }
    }

    return false
}

/**
 * 获取当前网络连接的类型信息
 * 返回的类型可以根据 ConnectivityManager.TYPE_ETHERNET 等字段来判断。
 */
fun getNetworkType(context: Context): Int{

    if(null != context){
        val connManage: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager

        val networkInfo = connManage.activeNetworkInfo
        if(null != networkInfo && networkInfo.isAvailable){
            ConnectivityManager.TYPE_ETHERNET
            return networkInfo.type

        }
    }
    return -1
}