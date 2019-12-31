package com.example.bloodpurification

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.bloodpurification.databinding.ActivityMainBinding
import com.example.bloodpurification.screens.graph.GraphViewModel
import com.example.bloodpurification.screens.input.InputViewModel
import com.example.bloodpurification.screens.start.StartViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModelInput : InputViewModel
    private lateinit var viewModelStart : StartViewModel
    private lateinit var viewModelGraph : GraphViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        val navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        binding.lifecycleOwner = this

        viewModelInput = ViewModelProviders.of(this).get(InputViewModel::class.java)
        viewModelStart = ViewModelProviders.of(this).get(StartViewModel::class.java)
        viewModelGraph = ViewModelProviders.of(this).get(GraphViewModel::class.java)

        viewModelInput.graphYSeries.observe(this, Observer {
            if (viewModelInput.graphYSeries.value == null) {
                Log.e("MainActivity", "passed graphYSeries is null")
            } else {
                viewModelGraph.updateYSeries(viewModelInput.graphYSeries.value!!)
                viewModelGraph.updateMaxHeight(viewModelInput.maxHeight)
            }
        })

        viewModelInput.graphZSeries.observe(this, Observer {
            if (viewModelInput.graphZSeries.value == null) {
                Log.e("MainActivity", "passed graphZSeries is null")
            } else {
                viewModelGraph.updateZSeries(viewModelInput.graphZSeries.value!!)
                viewModelGraph.updateMaxHeight(viewModelInput.maxHeight)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
