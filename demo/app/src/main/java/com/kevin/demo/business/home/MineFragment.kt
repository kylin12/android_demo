package com.kevin.demo.business.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kevin.demo.R
import com.kevin.demo.bean.UserBean

class MineFragment :   Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.mine_fragment,container,false)
        //数据库的使用 测试数据
        var userBean= UserBean()
        userBean.nickName="默默-个人中心"
//        DaoManager.getInstance().saveUserBean(userBean)
//        var user= DaoManager.getInstance().userBean
//        Toast.makeText(context, user.nickName, Toast.LENGTH_SHORT).show()
        return view
    }
}