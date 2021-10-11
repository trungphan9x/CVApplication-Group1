package com.trung.cvapplication.work.skilllist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.trung.cvapplication.databinding.FragmentSkillItemBinding

class SkillAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<SkillAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentSkillItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.skill.text = item
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentSkillItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val skill: TextView = binding.tvSkill

    }

}