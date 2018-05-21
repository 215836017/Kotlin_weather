package com.fzq.kotlin_weather.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyFragmentAdapter : FragmentPagerAdapter {

    var fragments: MutableList<Fragment> = ArrayList()

    constructor(fm: FragmentManager, fragments: MutableList<Fragment>) : super(fm) {
        this.fragments = fragments
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

}