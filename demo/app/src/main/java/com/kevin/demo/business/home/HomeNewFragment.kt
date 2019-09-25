package com.kevin.demo.business.home
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kevin.demo.R
import com.kevin.demo.bean.UserBean
import com.kevin.demo.common.base.BaseFragment
import com.kevin.demo.component.DaggerUserBeanComPonent
import com.kevin.demo.databinding.HomeNewFragmentBinding
import javax.inject.Inject


//LifecycleActivity
class  HomeNewFragment: BaseFragment(){
   private lateinit var homeNewFragmentBinding : HomeNewFragmentBinding

    @Inject
    lateinit var userBean: UserBean

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeNewFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.home_new_fragment,
            container,
            false
        )

        return  homeNewFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        DaggerUserBeanComPonent.create().inject(this)
        homeNewFragmentBinding.setLifecycleOwner(viewLifecycleOwner)

        homeNewFragmentBinding.userBean=userBean
    }






}


