package com.example.bloodpurification.screens.graph

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentGraphBinding
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
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

        viewModel.graphYSeries.observe(this, Observer {
            clearSeries()
            addSeries(viewModel.graphYSeries.value)
        })
        viewModel.graphZSeries.observe(this, Observer {
            addSeries(viewModel.graphZSeries.value)
        })

        configureGraph(binding.graph)
        return binding.root
    }

    private fun configureGraph(graph: GraphView) {
        graph.viewport.isScrollable = true
        graph.viewport.isScalable = true
        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setScrollableY(true)
        graph.viewport.setMinX(0.toDouble())
        graph.viewport.setMaxX(1500.toDouble())
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.setMinY(0.toDouble())
        graph.legendRenderer.align = LegendRenderer.LegendAlign.TOP
        graph.legendRenderer.isVisible = true
    }

    private fun clearSeries() {
         binding.graph.removeAllSeries()
    }

    private fun addSeries(series: LineGraphSeries<DataPoint>?) {
        if (series == null)
            Log.e("GraphFragment", "Value passed to drawGraph is null")
        else {
            binding.graph.addSeries(series)
            binding.graph.viewport.setMaxY(1.5*viewModel.maxHeight)
        }
    }
}