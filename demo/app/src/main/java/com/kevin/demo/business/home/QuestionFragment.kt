package com.kevin.demo.business.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.kevin.demo.R

class  QuestionFragment:Fragment(){
    lateinit var tabLayout: TabLayout
    lateinit var viewPager:ViewPager
    private val liststr = ArrayList<String>(3)
    private val mFragment = ArrayList<Fragment>(3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.question_fragment,container,false)
        tabLayout=view.findViewById(R.id.tabLayout)
        viewPager=view.findViewById(R.id.viewPager)
        initPager()
        initData()
        return view
    }

    private fun initData() {

    }

    private fun initPager() {
        var newFragment=HomeNewFragment()
        var replyFragment=HomeReplyFragment()
        var expertFragment=HomeExpertFragment()
        mFragment.add(newFragment)
        mFragment.add(replyFragment)
        mFragment.add(expertFragment)

        liststr.add("页面一")
        liststr.add("页面二")
        liststr.add("页面三")
        //关联viewpager
        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter=MyAdapter(mFragment,liststr,childFragmentManager)

    }
    class  MyAdapter(mFragment:ArrayList<Fragment>,listStr:ArrayList<String>,fm: FragmentManager) : FragmentPagerAdapter(fm) {
          var mFragment=mFragment
          var listStr=listStr

        override fun getItem(position: Int): Fragment {
            return mFragment[position]
        }

        override fun getCount(): Int {
            return mFragment.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listStr[position]
        }

    }
}