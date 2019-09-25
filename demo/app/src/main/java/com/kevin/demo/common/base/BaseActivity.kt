package com.kevin.demo.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(){
    lateinit var myLocationListener: LifeCycleListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLocationListener()
        initParams(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
    }

    abstract fun initParams(bundle: Bundle?)
    abstract fun layoutId():Int
    abstract fun initView()
    abstract fun initData()

    private fun initLocationListener() {
        myLocationListener = LifeCycleListener(this, lifecycle,null)
        lifecycle.addObserver(myLocationListener)

    }


}