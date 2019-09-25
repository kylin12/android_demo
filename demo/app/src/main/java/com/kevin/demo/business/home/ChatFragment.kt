package com.kevin.demo.business.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kevin.demo.R
import com.kevin.demo.bean.UserBean

class  ChatFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.chat_fragment,container,false)
        var userBean= UserBean()
        return view
    }
}

