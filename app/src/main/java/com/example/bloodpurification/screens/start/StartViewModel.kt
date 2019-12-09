package com.example.bloodpurification.screens.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bloodpurification.recycler.Point

class StartViewModel : ViewModel() {
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

}
