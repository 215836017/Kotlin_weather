package com.fzq.kotlin_weather.json2bean

import java.util.Date

data class Daily_forecast (var cond_code_d: String,
    var cond_code_n: String,
    var cond_txt_d: String,
    var cond_txt_n: String,
    var date: Date,
    var hum: String,
    var mr: String,
    var ms: String,
    var pcpn: String,
    var pop: String,
    var pres: String,
    var sr: String,
    var ss: String,
    var tmp_max: String,
    var tmp_min: String,
    var uv_index: String,
    var vis: String,
    var wind_deg: String,
    var wind_dir: String,
    var wind_sc: Date,
    var wind_spd: String
)