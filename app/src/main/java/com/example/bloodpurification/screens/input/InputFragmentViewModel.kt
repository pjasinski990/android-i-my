package com.example.bloodpurification.screens.input

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputFragmentViewModel : ViewModel(){
    val cPre = MutableLiveData<Double>()
    val cPost = MutableLiveData<Double>()
    val cEnd = MutableLiveData<Double>()
    val vTotal = MutableLiveData<Double>()
    val clearanceInter = MutableLiveData<Double>()
    val genRate = MutableLiveData<Double>()
    val clearanceAvg = MutableLiveData<Double>()
    val tTreatment= MutableLiveData<Double>()

    fun updateCPre(newValue : Double) {
        cPre.value = newValue
    }
    fun updateCPost(newValue : Double) {
        cPost.value = newValue
    }
    fun updateCEnd(newValue : Double) {
        cEnd.value = newValue
    }
    fun updateVTotal(newValue : Double) {
        vTotal.value = newValue
    }
    fun updateClearanceInter(newValue : Double) {
        clearanceInter.value = newValue
    }
    fun updateGenRate(newValue : Double) {
        genRate.value = newValue
    }
    fun updateClearanceAvg(newValue : Double) {
        clearanceAvg.value = newValue
    }
    fun updateTTreatment(newValue : Double) {
        tTreatment.value = newValue
    }
}