package com.example.bloodpurification.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {
    var _somethin = MutableLiveData<Double>()

    fun updatesth(newValue : Double){
        _somethin.value = newValue
    }

}
