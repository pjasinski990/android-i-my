package com.example.bloodpurification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bloodpurification.databinding.FragmentStartBinding

class Start : Fragment() {
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

        return binding.root
    }
}