package com.example.bloodpurification.screens.input

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel : ViewModel(){
    private val _cPre = MutableLiveData<Double>()
    val cPre: LiveData<Double>
        get() = _cPre

    private val _cPost = MutableLiveData<Double>()
    val cPost: LiveData<Double>
        get() = _cPost

    private val _cEnd = MutableLiveData<Double>()
    val cEnd: LiveData<Double>
        get() = _cEnd

    private val _vTotal = MutableLiveData<Double>()
    val vTotal: LiveData<Double>
        get() = _vTotal

    private val _clearanceInter = MutableLiveData<Double>()
    val clearanceInter: LiveData<Double>
        get() = _clearanceInter

    private val _genRate = MutableLiveData<Double>()
    val genRate: LiveData<Double>
        get() = _genRate

    private val _clearanceAvg = MutableLiveData<Double>()
    val clearanceAvg: LiveData<Double>
        get() = _clearanceAvg

    private val _tTreatment = MutableLiveData<Double>()
    val tTreatment: LiveData<Double>
        get() = _tTreatment

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