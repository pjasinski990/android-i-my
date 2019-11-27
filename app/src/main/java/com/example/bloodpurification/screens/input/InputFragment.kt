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


class InputFragment : Fragment() {

    private lateinit var viewModel: InputFragmentViewModel
    private lateinit var binding : FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_input, container,false)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[InputFragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")


        val navController = findNavController()
        binding.inputButton.setOnClickListener {
            navController.navigate(R.id.action_input_to_simulation)
        }
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.updateCEnd(binding.editText1.text.toString().toDouble())
    }
}