package com.example.bloodpurification.screens.graph

import android.os.Bundle
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

class GraphFragment : Fragment() {

    private lateinit var viewModel: GraphViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGraphBinding>(inflater,
            R.layout.fragment_graph, container,false)
        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(GraphViewModel::class.java)
        viewModel.pointsArray.observe(this, Observer { drawGraph(viewModel.pointsArray.value)})

        return binding.root
    }

    private fun drawGraph(array: ArrayList<Point>?) {
        if (array != null) {
            for (item in array) {
                TODO("graph implementation")
            }
        }
    }
}