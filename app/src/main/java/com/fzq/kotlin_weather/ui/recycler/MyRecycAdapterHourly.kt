package com.fzq.kotlin_weather.ui.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.json2bean.Hourly
import com.fzq.kotlin_weather.utils.ImageUtil

class MyRecycAdapterHourly(val context: Context, val list: List<Hourly>) : RecyclerView.Adapter<MyRecycAdapterHourly.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_myfragment_hourly_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hourly = list[position]

        holder.time.text = hourly.time.split(" ")[1]
        holder.icon.setImageResource(ImageUtil.getImageIdByCode(hourly.cond_code))
        holder.temperature.text = hourly.tmp
    }


    class ViewHolder : RecyclerView.ViewHolder {

        var time: TextView
        var icon: ImageView
        var temperature: TextView

        constructor(view: View) : super(view) {
            time = view.findViewById(R.id.myFrag_hourlyItem_text_time)
            icon = view.findViewById(R.id.myFrag_hourlyItem_image_weatherIcon)
            temperature = view.findViewById(R.id.myFrag_hourlyItem_text_temperature)
        }
    }
}