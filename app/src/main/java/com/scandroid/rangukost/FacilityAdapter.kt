package com.scandroid.rangukost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FacilityAdapter(private val facilities: List<String>) : RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_facility, parent, false)
        return FacilityViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacilityViewHolder, position: Int) {
        holder.bind(facilities[position])
    }

    override fun getItemCount(): Int {
        return facilities.size
    }

    class FacilityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvFacilityName: TextView = itemView.findViewById(R.id.tvFacilityName)

        fun bind(facility: String) {
            tvFacilityName.text = facility
        }
    }
}
