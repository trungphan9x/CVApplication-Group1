package com.trung.cvapplication.work.skilllist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import com.trung.cvapplication.R
import com.trung.cvapplication.databinding.FragmentSkillItemBinding
import com.trung.cvapplication.work.skilllist.SkillListFragment.Companion.DELETE_ID
import com.trung.cvapplication.work.skilllist.SkillListFragment.Companion.DETAIL_ID

class SkillAdapter(private val values: ArrayList<String>) :
    RecyclerView.Adapter<SkillAdapter.ViewHolder>() {

    private var onItemClickListener: ((Int, Int, String, View) -> Unit)? = null

    fun deleteItem(position : Int) {
        values.removeAt(position)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: ((Int, Int, String, View) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

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
        holder.rootView.setOnLongClickListener { rootView ->
            val popup = PopupMenu(rootView.context, holder.skill).apply {
                inflate(R.menu.skill_menu)
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.skill_menu_delete ->    {
                            //handle menu1 click
                            onItemClickListener?.invoke(DELETE_ID, position, item, rootView)
                            true
                        }

                        R.id.skill_menu_detail ->  {
                            //handle menu1 click
                            onItemClickListener?.invoke(DETAIL_ID, position, item, rootView)
                            true
                        }
                        else -> false
                    }
                }
            }
            popup.show()
            true
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentSkillItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val skill: TextView = binding.tvSkill
        val rootView = binding.root
    }
}