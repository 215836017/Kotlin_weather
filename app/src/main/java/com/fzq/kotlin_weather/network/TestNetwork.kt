package com.fzq.kotlin_weather.network

import com.fzq.kotlin_weather.*
import com.fzq.kotlin_weather.json2bean.WeatherNow
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val okhttpClient: OkHttpClient = OkHttpClient()
fun testGet(path: String) {

    val request = Request.Builder().url(path).build()

    val response = okhttpClient.newCall(request).execute()

    if (response.isSuccessful) {
        println("response.code(): " + response.code())
        println("response.body(): " + response.body()?.string())

    }
    /*
    请求："https://free-api.heweather.com/s6/weather/now?location=hangzhou&key=458c682400df47efb841a69154d7677d"
    响应结果：
    04-17 22:29:11.768 24591-24633/com.fzq.kotlin_weather
    I/System.out: response.code(): 200
    04-17 22:29:11.770 24591-24633/com.fzq.kotlin_weather
    I/System.out: response.body():
    {"HeWeather6":[{"basic":{"cid":"CN101210101","location":"杭州","parent_city":"杭州",
    "admin_area":"浙江","cnty":"中国","lat":"30.28745842","lon":"120.15357971","tz":"+8.00"},
    "update":{"loc":"2018-04-17 21:47","utc":"2018-04-17 13:47"},"status":"ok","now":{"cloud":
    "0","cond_code":"100","cond_txt":"晴","fl":"14","hum":"46","pcpn":"0.0","pres":"1018","
    tmp":"16","vis":"10","wind_deg":"83","wind_dir":"东风","wind_sc":"2","wind_spd":"9"}}]}
     */

}


fun testRetrofitGet(path: String): String? {
    val retrofit = Retrofit.Builder()
//            .baseUrl("https://free-api.heweather.com/s6/weather/")
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofitGet = retrofit.create(RetrofitGet::class.java)

    val call = retrofitGet.queryWeatherNow(path, heFeng_key)

    val response = call.execute()

    if (response.isSuccessful) {
        println("response.code = " + response.code())
        val result = response.body()?.string()
        println("testRetrofitGet() -- response.body() = $result")
        val gson = Gson()
        val json = gson.fromJson(result, WeatherNow::class.java)

        println("打印转换为json后的结果：json.heWeather6[0].now.cond_txt = " + json.HeWeather6)  // 打印ok了，哈哈哈。。。

        return result
    }
    return "testRetrofitGet is error"
    /*
    请求："https://free-api.heweather.com/s6/weather/now?location=hangzhou&key=458c682400df47efb841a69154d7677d"
    响应结果：
    04-17 22:55:27.866 24920-24975/com.fzq.kotlin_weather I/System.out: response.code(): 200
    response.body(): {"HeWeather6":[{"basic":{"cid":"CN101210101","location":"杭州","parent_city":
    "杭州","admin_area":"浙江","cnty":"中国","lat":"30.28745842","lon":"120.15357971","tz":"+8.00"},
    "update":{"loc":"2018-04-17 22:47","utc":"2018-04-17 14:47"},"status":"ok","now":{"cloud":"0",
    "cond_code":"100","cond_txt":"晴","fl":"14","hum":"48","pcpn":"0.0","pres":"1018","tmp":"15",
    "vis":"10","wind_deg":"107","wind_dir":"东南风","wind_sc":"1","wind_spd":"4"}}]}
     */
}
