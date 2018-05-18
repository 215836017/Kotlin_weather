package com.fzq.kotlin_weather.utils

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

/**
 * 获取当前位置的经纬度数值
 */
fun getCurrentLocation(context: Context): String {
    var latitude: Double
    var longitude: Double

    if (null != context) {
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE)
                as LocationManager
        try {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) { //从gps获取经纬度

                val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (null != lastKnownLocation) {
                    latitude = lastKnownLocation.latitude
                    longitude = lastKnownLocation.longitude

                    return "" + latitude + "," + longitude
                } else {
                    // //当GPS信号弱没获取到位置的时候又从网络获取
                    getLngAndLatWithNetwork(locationManager)
                }
            }
        } catch (e: SecurityException) {
        }

    }

    return ""
}

/**
 * 从网络获取经纬度
 */
fun getLngAndLatWithNetwork(locationManager: LocationManager): String {

    var latitude: Double
    var longitude: Double
    val myLocationManager = MyLocationListener()

    try {
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000L, 0F, myLocationManager)
        val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        if(null != location){
            latitude = location.latitude
            longitude = location.longitude

            return "" + latitude  + "," + longitude
        }
    }catch (e: SecurityException){}

    return ""
}

class MyLocationListener: LocationListener{
    //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
    override fun onLocationChanged(location: Location?) {
    }

    // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }
    // Provider被enable时触发此函数，比如GPS被打开
    override fun onProviderEnabled(provider: String?) {
    }
    // Provider被disable时触发此函数，比如GPS被关闭
    override fun onProviderDisabled(provider: String?) {
    }

}


