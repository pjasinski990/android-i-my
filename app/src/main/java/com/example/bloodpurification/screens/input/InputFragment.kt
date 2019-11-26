package com.example.bloodpurification.screens.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentInputBinding

private lateinit var viewModel : InputFragmentViewModel

class InputFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInputBinding>(inflater,
            R.layout.fragment_input, container,false)

        viewModel = ViewModelProviders.of(this).get(InputFragmentViewModel::class.java)


        val navController = findNavController()
        binding.inputButton.setOnClickListener {
            navController.navigate(R.id.action_input_to_simulation)
        }



        return binding.root
    }
}