package com.example.bloodpurification.screens.graph

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentGraphBinding
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class GraphFragment : Fragment() {

    private lateinit var viewModel: GraphViewModel
    private lateinit var binding: FragmentGraphBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_graph, container,false)
        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(GraphViewModel::class.java)
        viewModel.graphSeries.observe(this, Observer { drawGraph(viewModel.graphSeries.value)})

        binding.graph.viewport.isScrollable = true
        binding.graph.viewport.isScalable = true
        binding.graph.viewport.isXAxisBoundsManual = true
        binding.graph.viewport.setMinX(0.toDouble())
        binding.graph.viewport.setMaxX(1440.toDouble())
        binding.graph.viewport.isYAxisBoundsManual = true
        binding.graph.viewport.setMinY(0.toDouble())
        binding.graph.viewport.setMaxY(100.toDouble())

        return binding.root
    }

    private fun drawGraph(series: LineGraphSeries<DataPoint>?) {
        if (series == null)
            Log.e("GraphFragment", "Value passed to drawGraph is null")
        else {
            binding.graph.removeAllSeries()
            binding.graph.addSeries(series)
        }
    }
}