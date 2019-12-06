package com.example.bloodpurification.screens.input

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bloodpurification.recycler.Point

class InputViewModel : ViewModel(){
    private val _pointsList = MutableLiveData<ArrayList<Point>>()
    init {
        _pointsList.value = ArrayList()
    }

    val pointsList: LiveData<ArrayList<Point>>
    get() = _pointsList

    fun addPoint() {
        if (_pointsList.value == null) {
            _pointsList.value = ArrayList()
        }
        _pointsList.value!!.add(Point())
    }

    private val _cPre = MutableLiveData<Double>()
    val cPre: LiveData<Double>
        get() = _cPre

    fun updateCPre(newValue : Double) {
        _cPre.value = newValue
    }

    private val _cPost = MutableLiveData<Double>()
    val cPost: LiveData<Double>
        get() = _cPost

    fun updateCPost(newValue : Double) {
        _cPost.value = newValue
    }


    private val _cEnd = MutableLiveData<Double>()
    val cEnd: LiveData<Double>
        get() = _cEnd

    fun updateCEnd(newValue : Double) {
        _cEnd.value = newValue
    }


    private val _vTotal = MutableLiveData<Double>()
    val vTotal: LiveData<Double>
        get() = _vTotal

    fun updateVTotal(newValue : Double) {
        _vTotal.value = newValue
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