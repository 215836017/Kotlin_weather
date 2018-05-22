package com.fzq.kotlin_weather.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.json2bean.*
import com.fzq.kotlin_weather.network.*
import com.fzq.kotlin_weather.ui.recycler.MyRecycAdapterForecast
import com.fzq.kotlin_weather.ui.recycler.MyRecycAdapterHourly
import com.fzq.kotlin_weather.utils.ImageUtil
import com.fzq.kotlin_weather.utils.getWeekDay
import com.fzq.kotlin_weather.utils.printLog
import com.google.gson.Gson
import kotlinx.android.synthetic.main.frag_myfragment.*

class MyFragment : Fragment() {

    companion object {
        const val QUERY_WEATHER = 0x10
        const val query_forecast = "query_forecast"
        const val query_now = "query_now"
        const val query_hourly = "query_hourly"
    }

    val gson = Gson()

    var location: String = "hangzhou"
    var resultForecast: String? = "resultForecast"
    var resultNow: String? = "resultNow"
    var resultHourly: String? = "resultHourly"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.frag_myfragment, container, false)

        myFrag_image_setting.setOnClickListener(View.OnClickListener {
            startActivity(Intent(context, SettingActivity::class.java))
        })
        myFrag_image_addCity.setOnClickListener(View.OnClickListener {
            startActivity(Intent(context, SearchCityActivity::class.java))
        })
        return view

    }

    val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
                MyFragment.QUERY_WEATHER -> {
                    updateUI()
                }
                else -> {
                }
            }
        }
    }


    fun startQuaryWeahter() = object : Thread() {
        override fun run() {
            super.run()
            resultForecast = NetworkHelper.getWeatherForecast(location)
            resultNow = NetworkHelper.getWeatherNow(location)
            resultHourly = NetworkHelper.getWeatherHourly(location)

            mHandler.sendEmptyMessage(MyFragment.QUERY_WEATHER)
        }

    }.start()


    fun updateUI() {
        val weatherForecast = gson.fromJson(resultForecast, WeatherForecast::class.java)
        val weatherNow = gson.fromJson(resultNow, WeatherNow::class.java)
        val weatherHourly = gson.fromJson(resultHourly, WeatherHourly::class.java)

        showLog("updateUI-- weatherForecast.HeWeather6.size = ${weatherForecast.HeWeather6.size}, " +
                "weatherNow.HeWeather6.size = ${weatherNow.HeWeather6.size}, " +
                "weatherHourly.HeWeather6.size = ${weatherHourly.HeWeather6.size}")

        myFrag_text_currentTemperature.text = weatherNow.HeWeather6[0].now.tmp + "°"
        myFrag_iamge_weatherIcon.setImageResource(ImageUtil.getImageIdByCode(weatherNow.HeWeather6[0].now.cond_code))
        myFrag_text_weatherCase.text = weatherNow.HeWeather6[0].now.cond_txt
        myFrag_text_temperatureRange.text = weatherForecast.HeWeather6[0].daily_forecast[0].tmp_min + "°～ " + weatherForecast.HeWeather6[0].daily_forecast[0].tmp_max + "°"
        myFrag_text_date.text = "Toady " + getWeekDay(weatherNow.HeWeather6[0].update.loc.split(" ")[0])


        val layoutManageHourly = LinearLayoutManager(context)
        layoutManageHourly.orientation = OrientationHelper.HORIZONTAL
        val adapterHourly = MyRecycAdapterHourly(context!!, weatherHourly.HeWeather6[0].hourly)
        myFrag_RecyclerView_hourly.layoutManager = layoutManageHourly
        myFrag_RecyclerView_hourly.adapter = adapterHourly


        val layoutManagerForecast = LinearLayoutManager(context)
        layoutManagerForecast.orientation = OrientationHelper.VERTICAL
        val adapterForecast = MyRecycAdapterForecast(context!!, weatherForecast.HeWeather6[0].daily_forecast)
        myFrag_RecyclerView_forecast.layoutManager = layoutManagerForecast
        myFrag_RecyclerView_forecast.adapter = adapterForecast
    }

    private fun showLog(msg: String) {
        printLog("MyFragment.class", msg)
    }
}