package com.example.bloodpurification.screens.input

import android.os.Bundle
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

    private lateinit var viewModel: InputViewModel
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
            ViewModelProviders.of(this)[InputViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        navController = findNavController()

        binding.inputButton.setOnClickListener {
            sendData()
        }
        return binding.root
    }

    private fun sendData() {
        var missingInput = false

        var temp = binding.editText2.text.toString()

        // Total volume
        if (temp != "") {
            viewModel.updateVTotal(temp.toDouble())
        }
        else {
            missingInput = true
            binding.editText2.error = getString(R.string.inputRequiredError)
        }

        // Intercompartmental clearance
        temp = binding.editText3.text.toString()
        if (temp != "") {
            viewModel.updateClearanceInter(temp.toDouble())
        }
        else {
            missingInput = true
            binding.editText3.error = getString(R.string.inputRequiredError)
        }

        // Bilirubin generation rate
        temp = binding.editText4.text.toString()
        if (temp != "") {
            viewModel.updateGenRate(temp.toDouble())
        }
        else {
            missingInput = true
            binding.editText4.error = getString(R.string.inputRequiredError)
        }

        // Average clearance
        temp = binding.editText5.text.toString()
        if (temp != "") {
            viewModel.updateClearanceAvg(temp.toDouble())
        }
        else {
            missingInput = true
            binding.editText5.error = getString(R.string.inputRequiredError)
        }

        // Time of treatment
        temp = binding.editText6.text.toString()
        if (temp != "") {
            viewModel.updateTTreatment(temp.toDouble())
        }
        else {
            missingInput = true
            binding.editText6.error = getString(R.string.inputRequiredError)
        }

        // Post treatment bilirubin concentration

        if (!missingInput) {
            navController.navigate(R.id.action_input_to_simulation)
        }
    }
}