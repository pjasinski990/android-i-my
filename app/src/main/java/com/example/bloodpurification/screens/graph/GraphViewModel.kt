package com.example.bloodpurification.screens.graph

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class GraphViewModel : ViewModel() {
    private val _graphYSeries = MutableLiveData<LineGraphSeries<DataPoint>>()
    val graphYSeries: LiveData<LineGraphSeries<DataPoint>>
        get() = _graphYSeries

    private val _graphZSeries = MutableLiveData<LineGraphSeries<DataPoint>>()
    val graphZSeries: LiveData<LineGraphSeries<DataPoint>>
        get() = _graphZSeries

    fun updateYSeries(points: Array<DataPoint>) {
        val series = LineGraphSeries(points)
        series.color = Color.BLUE
        _graphYSeries.value  = series
    }

    fun updateZSeries(points: Array<DataPoint>) {
        val series = LineGraphSeries(points)
        series.color = Color.RED
        _graphZSeries.value = series
    }
}