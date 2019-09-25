package com.kevin.demo.business.demoviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public class SeekBarViewModel: ViewModel() {
    var seekbarValue=MutableLiveData<Int>()
}