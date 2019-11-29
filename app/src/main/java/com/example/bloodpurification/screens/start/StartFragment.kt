package com.example.bloodpurification.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.bloodpurification.MainActivity
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var viewModel : StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentStartBinding>(inflater,
            R.layout.fragment_start, container,false)

        val navController = findNavController()
        binding.startButton.setOnClickListener{
            navController.navigate(R.id.action_start_to_input)
        }

        viewModel = ViewModelProviders.of(activity as MainActivity).get(StartViewModel::class.java)
        viewModel._somethin.observe(this, Observer { _somethin -> binding.editText1.setText(_somethin.toString())})

        return binding.root
    }
}