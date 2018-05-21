package com.fzq.kotlin_weather.ui.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.json2bean.Daily_forecast
import com.fzq.kotlin_weather.utils.*

class MyRecycAdapterForecast(val context: Context, val list: List<Daily_forecast>) : RecyclerView.Adapter<MyRecycAdapterForecast.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_myfragment_forecast_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val daily_forecast = list[position]

        holder.week.text = getWeekDay(daily_forecast.date)
        holder.icon.setImageResource(ImageUtil.getImageIdByCode(daily_forecast.cond_code_d))
        holder.temperature.text = daily_forecast.tmp_min + "°～" + daily_forecast.tmp_max + "°"
        holder.wind.text = daily_forecast.wind_dir + ": " + daily_forecast.wind_sc + "级"

    }


    class ViewHolder : RecyclerView.ViewHolder {

        var week: TextView
        var icon: ImageView
        var temperature: TextView
        var wind: TextView

        constructor(view: View) : super(view) {
            week = view.findViewById(R.id.myFrag_forecastItem_text_week)
            icon = view.findViewById(R.id.myFrag_forecastItem_image_weatherIcon)
            temperature = view.findViewById(R.id.myFrag_forecastItem_text_temperature)
            wind = view.findViewById(R.id.myFrag_forecastItem_text_wind_dirAnd_sc)
        }
    }
}