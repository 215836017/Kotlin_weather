package com.fzq.kotlin_weather.ui

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.SP_LAST_LOCATION
import com.fzq.kotlin_weather.initSharedPreferences
import com.fzq.kotlin_weather.network.*
import com.fzq.kotlin_weather.utils.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 一个天气类App，练习Kotlin在Android项目中的使用
 * 使用和风天气提供的API： https://www.heweather.com
 *
 * 注意： 基于和风天气API s6 版本， 有个缺点：都是get方式，没有post
 */
class MainActivity : AppCompatActivity() {

//    val sp: SharedPreferences = initSharedPreferences(this)
    var location = ""
    var weatherForecast = ""

    val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what == 0x11) {
                MainAct_text_test.text = weatherForecast
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 第一步： 判断网络
//        if(!isNetworkConnected(this)){
//            Toast.makeText(this, "当前网络不可用，无法查询天气", Toast.LENGTH_LONG).show()
//
//            return
//        }

        // 第二步： 获取当前位置
//        location = getCurrentLocation(this)
//        showLog("获取的当前位置 = $location")
//        if (TextUtils.isEmpty(location)) {
//            // 获取程序上一次保存的位置的天气，
//            // 如果是第一次打开，则默认直接北京的天气
//            if (TextUtils.isEmpty(sp.getString(SP_LAST_LOCATION, ""))) {
//                location = ""
//            } else {
//                location = sp.getString(SP_LAST_LOCATION, "")
//            }
//        }

        // 第三步： 获取当前位置的天气

        MainAct_btn_test.setOnClickListener {
            println("开始连接服务器。。。")
            testHttpJson()
        }
    }


    fun testHttpJson() {
        object : Thread() {
            override fun run() {
                super.run()
                val path = "https://free-api.heweather.com/s6/weather/now?location=hangzhou&key=458c682400df47efb841a69154d7677d"
//                weatherForecast = getWeatherForecast(path)

//                testGet(path)

                weatherForecast = testRetrofitGet(path)


                handler.sendEmptyMessage(0x11)
                println("请求结束。。。")
                Log.i("asd", "请求结束。。。")
            }
        }.start()
    }

    private fun showLog(msg: String) {
        showLog("MainActivity.java", msg)
    }
}
