package com.fzq.kotlin_weather.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.network.getWeatherForecast
import com.fzq.kotlin_weather.network.testGet
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 一个天气类App，练习Kotlin在Android项目中的使用
 * 使用和风天气提供的API： https://www.heweather.com
 *
 * 注意： 基于和风天气API s6 版本， 有个缺点：都是get方式，没有post
 */
class MainActivity : AppCompatActivity() {

    var weatherForecast = ""

    var handler: Handler = object : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what == 0x11){
                MainAct_text_test.text = weatherForecast
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainAct_btn_test.setOnClickListener{
            println("开始连接服务器。。。")
            Log.i("asd", "开始连接服务器。。。")
            testHttpJson()
        }
    }

    fun testHttpJson(){
        object : Thread(){
            override fun run() {
                super.run()
                val path = "https://free-api.heweather.com/s6/weather/now?location=hangzhou&key=458c682400df47efb841a69154d7677d"
//                weatherForecast = getWeatherForecast(path)

                testGet(path)

                println("请求结束。。。")
                Log.i("asd", "请求结束。。。")
            }
        }.start()
    }
}
