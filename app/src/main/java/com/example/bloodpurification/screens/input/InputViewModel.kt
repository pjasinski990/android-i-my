package com.example.bloodpurification.screens.input

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint

class InputViewModel : ViewModel(){

    private val pointsCount = 2000
    private val step = 24.toDouble()*60.toDouble()/pointsCount.toDouble()

    private val _graphSeries = MutableLiveData<Array<DataPoint>>()
    val graphSeries: LiveData<Array<DataPoint>>
        get() = _graphSeries

    fun updateGraphSeries() {
        val xArray: MutableList<Double> = mutableListOf()
        val yArray: MutableList<Double> = mutableListOf()
        val zArray: MutableList<Double> = mutableListOf()


        var prevY = cPre.value!!
        var prevZ = cPre.value!!
        for (i in 0 until pointsCount) {
            xArray.add(i*step)
            if (xArray[i] < tTreatment.value!!)
                yArray.add(centralTreatmentEuler(prevY, prevZ))
            else
                yArray.add(centralPostEuler(prevY, prevZ))
            zArray.add(peripheralTreatmentEuler(prevY, prevZ))
            prevY = yArray[i]
            prevZ = zArray[i]
        }

        val temp: Array<DataPoint> = Array(pointsCount) { i-> DataPoint(xArray[i], yArray[i])}
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

    private fun centralTreatmentEuler(prevY: Double, prevZ: Double): Double {
        val vCentral = vTotal.value!!/3.toDouble()
        val dy = (genRate.value!! - clearanceAvg.value!!*prevY + clearanceInter.value!!*(prevZ - prevY))/vCentral*step
        Log.i("InputViewModel", "dy is $dy, v is $vCentral")
        return prevY + dy
    }
    private fun peripheralTreatmentEuler(prevY: Double, prevZ: Double): Double {
        val vPeripheral = 2.toDouble()/3.toDouble()*vTotal.value!!
        return prevY + (-1*clearanceAvg.value!!*prevY + genRate.value!! + clearanceInter.value!!*(prevY - prevZ))/vPeripheral*step
    }
    private fun centralPostEuler(prevY: Double, prevZ: Double): Double {
        val vCentral = vTotal.value!!/3.toDouble()
        return (prevZ-prevY)*clearanceInter.value!!*vCentral
    }
}