package com.fzq.kotlin_weather.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.fzq.kotlin_weather.R
import com.fzq.kotlin_weather.*
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity: AppCompatActivity(), CompoundButton.OnCheckedChangeListener, View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        initViews()

        viewsClick()
    }


    private fun initViews(){
        if(isAutoUpdateWeather){
            SettingAct_switch_autoUpdate.isChecked = true
            SettingAct_layout_updateInterval.visibility = View.VISIBLE
        }else{
            SettingAct_switch_autoUpdate.isChecked = false
            SettingAct_layout_updateInterval.visibility = View.INVISIBLE
        }

    }


    private fun viewsClick(){
        SettingAct_switch_autoUpdate.setOnCheckedChangeListener(this)

        SettingAct_layout_autoUpdate.setOnClickListener(this)
        SettingAct_layout_updateInterval.setOnClickListener(this)
        SettingAct_layout_checkNewVersion.setOnClickListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if(isChecked){
            SettingAct_layout_updateInterval.visibility = View.VISIBLE
        }else{
            SettingAct_layout_updateInterval.visibility = View.INVISIBLE
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.SettingAct_layout_autoUpdate -> {
                initViews()
            }
            R.id.SettingAct_layout_updateInterval ->{
                showUpdatePeriodItems()
            }
            R.id.SettingAct_layout_checkNewVersion -> {
                Toast.makeText(this, "检查新版本。。。", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showUpdatePeriodItems(){

    }

}