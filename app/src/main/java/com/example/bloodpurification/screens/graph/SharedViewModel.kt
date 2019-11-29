package com.example.bloodpurification.screens.graph

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){
    private val _cPre = MutableLiveData<Double>()
    private val _cPost = MutableLiveData<Double>()
    private val _cEnd = MutableLiveData<Double>()
    private val _vTotal = MutableLiveData<Double>()
    private val _clearanceInter = MutableLiveData<Double>()
    private val _genRate = MutableLiveData<Double>()
    private val _clearanceAvg = MutableLiveData<Double>()
    private val _tTreatment= MutableLiveData<Double>()

    fun updateCPre(newValue : Double) {
        _cPre.value = newValue
    }
    fun updateCPost(newValue : Double) {
        _cPost.value = newValue
    }
    fun updateCEnd(newValue : Double) {
        _cEnd.value = newValue
    }
    fun updateVTotal(newValue : Double) {
        _vTotal.value = newValue
    }
    fun updateClearanceInter(newValue : Double) {
        _clearanceInter.value = newValue
    }
    fun updateGenRate(newValue : Double) {
        _genRate.value = newValue
    }
    fun updateClearanceAvg(newValue : Double) {
        _clearanceAvg.value = newValue
    }
    fun updateTTreatment(newValue : Double) {
        _tTreatment.value = newValue
    }
}