package com.example.bloodpurification.screens.input

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint

class InputViewModel : ViewModel(){

    private val pointsCount = 1000
    private val step = 24.toDouble()*60.toDouble()/pointsCount.toDouble()

    //Array for central compartment graph points
    private val _graphYSeries = MutableLiveData<Array<DataPoint>>()
    val graphYSeries: LiveData<Array<DataPoint>>
        get() = _graphYSeries

    //Array for peripheral compartment graph points
    private val _graphZSeries = MutableLiveData<Array<DataPoint>>()
    val graphZSeries: LiveData<Array<DataPoint>>
        get() = _graphZSeries

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

        //For graph height scaling
        _maxHeight = if (yArray[0] > yArray[pointsCount-1]) {
            yArray[0]
        } else
            yArray[pointsCount-1]

        _graphYSeries.value = Array(pointsCount) { i-> DataPoint(xArray[i], yArray[i])}
        _graphZSeries.value = Array(pointsCount) { i-> DataPoint(xArray[i], zArray[i])}
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

    private val _inputsArray = arrayOf(
        cPre,
        vTotal,
        clearanceInter,
        genRate,
        clearanceAvg,
        tTreatment
    )
    val inputsArray: Array<LiveData<Double>>
        get() = _inputsArray

    private var _maxHeight = 0.0
    val maxHeight: Double
        get() = _maxHeight

    private fun centralTreatmentEuler(prevY: Double, prevZ: Double): Double {
        val vCentral = vTotal.value!!/3.toDouble()
        val dy = (genRate.value!! - clearanceAvg.value!!*prevY + clearanceInter.value!!*(prevZ - prevY))/vCentral*step
        Log.i("InputViewModel", "precentral dy is $dy")
        return prevY + dy
    }
    private fun peripheralTreatmentEuler(prevY: Double, prevZ: Double): Double {
        val vPeripheral = 2.toDouble()/3.toDouble()*vTotal.value!!
        val dy = (clearanceInter.value!!*(prevY - prevZ))/vPeripheral*step
        Log.i("InputViewModel", "precentral dy is $dy")
        return prevZ + dy
    }
    private fun centralPostEuler(prevY: Double, prevZ: Double): Double {
        val vCentral = vTotal.value!!/3.toDouble()
        val dy = (genRate.value!! + clearanceInter.value!!*(prevZ - prevY))/vCentral*step
        Log.i("InputViewModel", "postcentral dy is $dy")
        return prevY + dy
    }
}