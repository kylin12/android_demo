package com.kevin.demo.business.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.kevin.demo.R
import com.kevin.demo.business.demoviewmodel.SeekBarActivity

class LearnFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.learn_fragment,container,false)
        view.findViewById<Button>(R.id.btn_viewmodel).setOnClickListener{
            startActivity(Intent(activity,SeekBarActivity::class.java))
        }
        return view
    }
}