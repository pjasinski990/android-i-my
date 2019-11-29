package com.example.bloodpurification.screens.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GraphViewModel : ViewModel() {
    private val _pointsArray = MutableLiveData<ArrayList<Point>>()
    val pointsArray : LiveData<ArrayList<Point>>
        get() = _pointsArray

    fun updatePoints(array: ArrayList<Point>) {
        _pointsArray.value = array
    }
}