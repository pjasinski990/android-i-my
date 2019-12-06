package com.example.bloodpurification.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpurification.R

class PointAdapter(val pointsList: List<Point>) : RecyclerView.Adapter<PointAdapter.PointViewHolder>(){
    private val list = ArrayList<Point>()

    fun PointAdapter() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.new_item, parent, false)
        return PointViewHolder(v)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class PointViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun PointViewHolder(itemView: View) {
            val concentrationInput = itemView.findViewById<EditText>(R.id.concentrationInput)
            val timeInput = itemView.findViewById<EditText>(R.id.timeInput)
        }
    }
}