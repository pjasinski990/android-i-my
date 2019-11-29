package com.example.bloodpurification.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentStartBinding
import com.example.bloodpurification.screens.input.InputViewModel

class StartFragment : Fragment() {

    private lateinit var viewModel : InputViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentStartBinding>(inflater,
            R.layout.fragment_start, container,false)

        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(InputViewModel::class.java)
        


        val navController = findNavController()
        binding.startButton.setOnClickListener{
            navController.navigate(R.id.action_start_to_input)
        }

        return binding.root
    }
}