package com.example.candidatetestapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.candidatetestapp.R
import com.example.candidatetestapp.models.Company

class ProfilePageAdapter(val companies: List<Company>): RecyclerView.Adapter<ProfilePageAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var companyInfo: TextView = view.findViewById(R.id.profile_company)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.work_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.companyInfo.text = companies[position].name + ", " + companies[position].position
    }

    override fun getItemCount(): Int = companies.size
}