package com.example.bloodpurification.screens.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class GraphViewModel : ViewModel() {
    private val _graphSeries = MutableLiveData<LineGraphSeries<DataPoint>>()
    val graphSeries: LiveData<LineGraphSeries<DataPoint>>
        get() = _graphSeries

    fun updateSeries(points: Array<DataPoint>) {
        val series:  LineGraphSeries<DataPoint> = LineGraphSeries(points)
        series.isDrawDataPoints = true
        series.dataPointsRadius = 20f
        _graphSeries.value = series
    }
}