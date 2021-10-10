package com.trung.cvapplication.work.worklist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.trung.cvapplication.databinding.FragmentWorkItemBinding
import com.trung.cvapplication.model.remote.Work

class WorkAdapter(
    private val values: List<Work>
) : RecyclerView.Adapter<WorkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentWorkItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.company.text = item.companyName
        holder.location.text = item.location
        holder.pos.text = item.position
        holder.duration.text = item.duration
        holder.des.text = item.description
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentWorkItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val company: TextView = binding.tvCompanyValue
        val location: TextView = binding.tvLocationValue
        val pos: TextView = binding.tvPositionValue
        val duration: TextView = binding.tvDurationValue
        val des: TextView = binding.tvDescriptionValue
    }

}