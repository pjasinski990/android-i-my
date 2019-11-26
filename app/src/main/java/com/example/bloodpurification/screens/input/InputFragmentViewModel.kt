package com.example.bloodpurification.screens.input

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputFragmentViewModel : ViewModel(){
    val cPre = MutableLiveData<Double>()
    val cPost = MutableLiveData<Double>()
    val cEnd = MutableLiveData<Double>()
    val vTotal = MutableLiveData<Double>()
    val clearanceInter = MutableLiveData<Double>()

}