package com.kevin.demo.business.demoviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kevin.demo.R

class SeekBarFragment : Fragment() {
    lateinit var seekBar:SeekBar
    lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.demo_viewmodel,container,false)
        seekBar = view.findViewById(R.id.sb_seekBar)
        seekBarViewModel = ViewModelProviders.of(activity!!).get(SeekBarViewModel::class.java)
        subcribeSeekBar()
        return view
    }

    fun subcribeSeekBar(){
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBarViewModel.seekbarValue.value=p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        seekBarViewModel.seekbarValue.observe(this, Observer {
            seekBar.progress=it
        })
    }
}