package com.kevin.demo

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.kevin.demo.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var navController: NavController

    override fun initParams(bundle: Bundle?) {
    }

    override fun layoutId()=R.layout.activity_main

    override fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bnv_menu.setupWithNavController(navController)
    }

    override fun initData() {
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
