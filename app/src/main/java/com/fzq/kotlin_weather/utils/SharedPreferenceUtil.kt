package com.fzq.kotlin_weather.utils

import android.content.Context
import android.content.SharedPreferences
import com.fzq.kotlin_weather.sp_name

object SharedPreferenceUtil {

    fun initSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(sp_name, Context.MODE_PRIVATE)
    }

    fun inisEditor(context: Context): SharedPreferences.Editor {
        return initSharedPreferences(context).edit()
    }
}