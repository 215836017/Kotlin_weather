package com.fzq.kotlin_weather.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcast: BroadcastReceiver() {

    private val GPS_ACTION = "android.location.PROVIDERS_CHANGED"

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action!!.equals(GPS_ACTION)){

        }
    }
}