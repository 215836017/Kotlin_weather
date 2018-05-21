package com.fzq.kotlin_weather.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.network.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 一个天气类App，练习Kotlin在Android项目中的使用
 * 使用和风天气提供的API： https://www.heweather.com
 *
 * 注意： 基于和风天气API s6 版本， 有个缺点：都是get方式，没有post
 */
class MainActivity : AppCompatActivity() {

    var fragments: MutableList<Fragment> = ArrayList()

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

//        MainAct_btn_test.setOnClickListener {
//            println("开始连接服务器。。。")
//            testHttpJson()
//        }

//        var frag0 = MyFragment()
//        fragments.add(frag0)
//        val adapter = MyFragmentAdapter(supportFragmentManager, fragments = fragments)
//        MainAct_viewPager.adapter = adapter

        //  testHttpJson()
    }

    override fun onResume() {
        super.onResume()
        var frag0 = MyFragment()
        frag0.location = "hangzhou"
        frag0.startQuaryWeahter()

        fragments.add(frag0)
        val adapter = MyFragmentAdapter(supportFragmentManager, fragments)
        MainAct_viewPager.adapter = adapter
    }


    fun testHttpJson() {
        object : Thread() {
            override fun run() {
                super.run()
                val path = "https://free-api.heweather.com/s6/weather/now?location=hangzhou&key=458c682400df47efb841a69154d7677d"
//                weatherForecast = getWeatherForecast(path)

//                testGet(path)


                getWeatherForecast("hangzhou")
                getWeatherNow("hangzhou")
                getWeatherHourly("hangzhou")

                //  testRetrofitGet1("hangzhou")
            }
        }.start()
    }
}
