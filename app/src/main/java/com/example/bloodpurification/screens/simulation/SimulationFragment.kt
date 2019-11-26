package com.example.bloodpurification.screens.simulation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentGraphBinding

class SimulationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGraphBinding>(inflater,
            R.layout.fragment_graph, container,false)

        return binding.root
    }
}