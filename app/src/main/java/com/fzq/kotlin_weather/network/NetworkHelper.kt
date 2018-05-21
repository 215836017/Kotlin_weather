package com.fzq.kotlin_weather.network

import com.fzq.kotlin_weather.baseUrl
import com.fzq.kotlin_weather.heFeng_key
import com.fzq.kotlin_weather.utils.printLog
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    /**
     * 3-10天天气预报
     */
    fun getWeatherForecast(location: String): String? {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val retrofitGet = retrofit.create(RetrofitGet::class.java)

        val map = mapOf<String, String>(Pair("location", location),
                Pair("key", heFeng_key))

        val call = retrofitGet.queryWeatherForecast(map)
        val response = call.execute()
        if (response.isSuccessful) {
            val result = response.body()?.string()
            showLog("getWeatherForecast-- response.body()?.string() = $result")
            return result
        } else {
            return "getWeatherForecast is error"
        }
    }

    /**
     * 实况天气
     */
    fun getWeatherNow(location: String): String? {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val retrofitGet = retrofit.create(RetrofitGet::class.java)
        val call = retrofitGet.queryWeatherNow(location, heFeng_key)
        val response = call.execute()
        if (response.isSuccessful) {
            val result = response.body()?.string()
            showLog("getWeatherNow -- response.body()?.string() = " + result)
            return result
        } else {
            return "getWeatherNow is error"
        }
    }

    /**
     * 逐小时预报
     */
    fun getWeatherHourly(location: String): String? {
        val retrofitGet = Retrofit.Builder()
                .baseUrl(baseUrl)
                .build()
                .create(RetrofitGet::class.java)
        val map = mapOf<String, String>(Pair("location", location),
                Pair("key", heFeng_key))
        val call = retrofitGet.queryWeahterHourly(map)
        val response = call.execute()

        if (response.isSuccessful) {
            val result = response.body()?.string()
            showLog("getWeatherHourly-- response.body()?.string() = $result")
//            return result
            return exampleHourly
        } else {
            return "getWeatherHourly is error"
        }
    }


    private fun showLog(msg: String) {
        printLog("NetworkHelper.kt", msg)
    }


val exampleHourly = """
{
    "HeWeather6": [
        {
            "basic": {
                "cid": "CN101010100",
                "location": "北京",
                "parent_city": "北京",
                "admin_area": "北京",
                "cnty": "中国",
                "lat": "39.90498734",
                "lon": "116.40528870",
                "tz": "8.0"
            },
            "hourly": [
                {
                    "cloud": "8",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "84",
                    "pop": "0",
                    "pres": "1018",
                    "time": "2017-10-27 01:00",
                    "tmp": "8",
                    "wind_deg": "49",
                    "wind_dir": "东北风",
                    "wind_sc": "微风",
                    "wind_spd": "2"
                },
                {
                    "cloud": "8",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "81",
                    "pop": "0",
                    "pres": "1018",
                    "time": "2017-10-27 04:00",
                    "tmp": "8",
                    "wind_deg": "29",
                    "wind_dir": "东北风",
                    "wind_sc": "微风",
                    "wind_spd": "2"
                },
                {
                    "cloud": "6",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "95",
                    "pop": "0",
                    "pres": "1019",
                    "time": "2017-10-27 07:00",
                    "tmp": "8",
                    "wind_deg": "37",
                    "wind_dir": "东北风",
                    "wind_sc": "微风",
                    "wind_spd": "2"
                },
                {
                    "cloud": "2",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "75",
                    "pop": "0",
                    "pres": "1018",
                    "time": "2017-10-27 10:00",
                    "tmp": "14",
                    "wind_deg": "108",
                    "wind_dir": "东南风",
                    "wind_sc": "微风",
                    "wind_spd": "3"
                },
                {
                    "cloud": "0",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "62",
                    "pop": "0",
                    "pres": "1016",
                    "time": "2017-10-27 13:00",
                    "tmp": "16",
                    "wind_deg": "158",
                    "wind_dir": "东南风",
                    "wind_sc": "微风",
                    "wind_spd": "6"
                },
                {
                    "cloud": "0",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "73",
                    "pop": "0",
                    "pres": "1016",
                    "time": "2017-10-27 16:00",
                    "tmp": "15",
                    "wind_deg": "162",
                    "wind_dir": "东南风",
                    "wind_sc": "微风",
                    "wind_spd": "6"
                },
                {
                    "cloud": "3",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "92",
                    "pop": "0",
                    "pres": "1018",
                    "time": "2017-10-27 19:00",
                    "tmp": "13",
                    "wind_deg": "206",
                    "wind_dir": "西南风",
                    "wind_sc": "微风",
                    "wind_spd": "4"
                },
                {
                    "cloud": "19",
                    "cond_code": "100",
                    "cond_txt": "晴",
                    "hum": "96",
                    "pop": "0",
                    "pres": "1019",
                    "time": "2017-10-27 22:00",
                    "tmp": "13",
                    "wind_deg": "212",
                    "wind_dir": "西南风",
                    "wind_sc": "微风",
                    "wind_spd": "1"
                }
            ],
            "status": "ok",
            "update": {
                "loc": "2017-10-26 23:09",
                "utc": "2017-10-26 15:09"
            }
        }
    ]
}
"""