package com.example.bloodpurification

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 : Button = findViewById(R.id.calcButton)
        button1.setOnClickListener {
            calculate()
        }

    }

    private fun calculate() {
        Toast.makeText(this, "hello there",
            Toast.LENGTH_SHORT).show()
    }
}
