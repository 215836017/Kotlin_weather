package com.fzq.kotlin_weather.utils

import com.fzq.kotlin_weather.R

/**
 * 这里要使用类的原因是 R 在文件的方法中找不到的
 */
object ImageUtil {
    fun getImageIdByCode(code: String): Int =
            when (code) {
                "100" -> R.drawable.icon_one_o_o
                "100n" -> R.drawable.icon_one_o_o_n
                "101" -> R.drawable.icon_one_o_one
                "102" -> R.drawable.icon_one_o_two
                "103" -> R.drawable.icon_one_o_three
                "103n" -> R.drawable.icon_one_o_three_n
                "104" -> R.drawable.icon_one_o_four
                "104n" -> R.drawable.icon_one_o_four_n
                "200" -> R.drawable.icon_two_o_o
                "201" -> R.drawable.icon_two_o_one
                "202" -> R.drawable.icon_two_o_two
                "203" -> R.drawable.icon_two_o_three
                "204" -> R.drawable.icon_two_o_four
                "205" -> R.drawable.icon_two_o_five
                "206" -> R.drawable.icon_two_o_six
                "207" -> R.drawable.icon_two_o_seven
                "208" -> R.drawable.icon_two_o_eight
                "209" -> R.drawable.icon_two_o_nine
                "210" -> R.drawable.icon_two_one_o
                "211" -> R.drawable.icon_two_one_one
                "212" -> R.drawable.icon_two_one_two
                "213" -> R.drawable.icon_two_one_three
                "300" -> R.drawable.icon_three_o_o
                "300n" -> R.drawable.icon_three_o_o_n
                "301" -> R.drawable.icon_three_o_one
                "301n" -> R.drawable.icon_three_o_one_n
                "302" -> R.drawable.icon_three_o_two
                "303" -> R.drawable.icon_three_o_three
                "304" -> R.drawable.icon_three_o_four
                "305" -> R.drawable.icon_three_o_five
                "306" -> R.drawable.icon_three_o_six
                "307" -> R.drawable.icon_three_o_seven
                "309" -> R.drawable.icon_three_o_nine
                "310" -> R.drawable.icon_three_one_o
                "311" -> R.drawable.icon_three_one_one
                "312" -> R.drawable.icon_three_one_two
                "313" -> R.drawable.icon_three_one_three
                "400" -> R.drawable.icon_four_o_o
                "401" -> R.drawable.icon_four_o_one
                "402" -> R.drawable.icon_four_o_two
                "403" -> R.drawable.icon_four_o_three
                "404" -> R.drawable.icon_four_o_four
                "405" -> R.drawable.icon_four_o_five
                "406" -> R.drawable.icon_four_o_six
                "406n" -> R.drawable.icon_four_o_six_n
                "407" -> R.drawable.icon_four_o_seven
                "407n" -> R.drawable.icon_four_o_seven_n
                "500" -> R.drawable.icon_five_o_o
                "501" -> R.drawable.icon_five_o_one
                "502" -> R.drawable.icon_five_o_two
                "503" -> R.drawable.icon_five_o_three
                "504" -> R.drawable.icon_five_o_four
                "507" -> R.drawable.icon_five_o_seven
                "508" -> R.drawable.icon_five_o_eight
                "900" -> R.drawable.icon_nine_o_o
                "901" -> R.drawable.icon_nine_o_one
                "999" -> R.drawable.icon_nine_nine_nine
                else -> R.mipmap.ic_launcher_round
            }
}