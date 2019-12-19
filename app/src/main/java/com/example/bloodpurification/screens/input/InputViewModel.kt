package com.example.bloodpurification.screens.input

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint

class InputViewModel : ViewModel(){

    private val _graphSeries = MutableLiveData<Array<DataPoint>>()
    val graphSeries: LiveData<Array<DataPoint>>
        get() = _graphSeries

    private fun getConcentration(t: Double): Double {
        return (t*(-clearanceAvg.value!!)*cPre.value!! + genRate.value!!)/((1/3)*vTotal.value!!)
    }

    fun updateGraphSeries() {
        val step: Double = tTreatment.value!!/100.0
        val temp = Array(100) { i -> DataPoint(i*step, getConcentration(i*step))}
        _graphSeries.value = temp
    }

    private val _vTotal = MutableLiveData<Double>()
    val vTotal: LiveData<Double>
        get() = _vTotal

    fun updateVTotal(newValue : Double) {
        _vTotal.value = newValue
    }

    private val _cPre = MutableLiveData<Double>()
    val cPre: LiveData<Double>
        get() = _cPre

    fun updateCPre(newValue: Double) {
        _cPre.value = newValue
    }

    private val _clearanceInter = MutableLiveData<Double>()
    val clearanceInter: LiveData<Double>
        get() = _clearanceInter

    fun updateClearanceInter(newValue : Double) {
        _clearanceInter.value = newValue
    }

    private val _genRate = MutableLiveData<Double>()
    val genRate: LiveData<Double>
        get() = _genRate

    fun updateGenRate(newValue : Double) {
        _genRate.value = newValue
    }

    private val _clearanceAvg = MutableLiveData<Double>()
    val clearanceAvg: LiveData<Double>
        get() = _clearanceAvg

    fun updateClearanceAvg(newValue : Double) {
        _clearanceAvg.value = newValue
    }

    private val _tTreatment = MutableLiveData<Double>()
    val tTreatment: LiveData<Double>
        get() = _tTreatment

    fun updateTTreatment(newValue : Double) {
        _tTreatment.value = newValue
    }
}