package com.example.bloodpurification.screens.communication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bloodpurification.R
import com.example.bloodpurification.databinding.FragmentInputBinding


class InputFragment : Fragment() {

    private lateinit var viewModel: InputFragmentViewModel
    private lateinit var binding: FragmentInputBinding
    private lateinit var navController : NavController

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


        navController = findNavController()
        binding.inputButton.setOnClickListener {
            sendData()
        }
        return binding.root
    }

    private fun sendData() {
        if (binding.editText1.text.toString() != "") {
            viewModel.updateCEnd(binding.editText1.text.toString().toDouble())
            navController.navigate(R.id.action_input_to_simulation)
        }
        else {
            binding.editText1.setBackgroundColor(Color.LTGRAY)
        }
//            viewModel.updateCPost()
//            viewModel.updateCPre()
//            viewModel.updateClearanceAvg()
//            viewModel.updateClearanceInter()
//            viewModel.updateGenRate()
//            viewModel.updateTTreatment()
//            viewModel.updateVTotal()

    }


}