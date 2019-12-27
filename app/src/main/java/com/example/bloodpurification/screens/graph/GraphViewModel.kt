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
    fun updateYSeries(points: Array<DataPoint>) {
        val series = LineGraphSeries(points)
        series.title = "Central concentration over time"
        series.color = Color.BLUE
        _graphYSeries.value  = series
    }

    private val _graphZSeries = MutableLiveData<LineGraphSeries<DataPoint>>()
    val graphZSeries: LiveData<LineGraphSeries<DataPoint>>
        get() = _graphZSeries

    fun updateZSeries(points: Array<DataPoint>) {
        val series = LineGraphSeries(points)
        series.title = "Peripheral concentration over time"
        series.color = Color.RED
        _graphZSeries.value = series
    }

    private var _maxHeight = 0.0
    val maxHeight: Double
        get() = _maxHeight
    fun updateMaxHeight(height: Double) {
        _maxHeight = height
    }
}