package com.example.bloodpurification.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpurification.R

class PointAdapter(private val pointsList: ArrayList<Point>?) : RecyclerView.Adapter<PointAdapter.PointViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.new_item, parent, false) as LinearLayout
        return PointViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pointsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        holder.button.setOnClickListener {
            pointsList?.removeAt(position)
            notifyDataSetChanged()
        }
    }

    class PointViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.remove_button)
    }
}