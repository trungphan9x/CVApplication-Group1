package com.trung.cvapplication.work.skilllist

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.trung.cvapplication.R
import kotlinx.android.synthetic.main.fragment_skill_list.*
import android.database.sqlite.SQLiteDatabase

import android.content.ContentValues

import android.content.DialogInterface
import android.view.*
import android.widget.AdapterView

import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class SkillListFragment : Fragment() {

    private var columnCount = 2
    private var skills = arrayListOf<String>().apply {
        addAll(arrayListOf("C++", "Retrofit", "DataBinding", "Android", "Java", "Mobile", "Backend","C++", "Retrofit", "DataBinding", "Android", "Java", "Mobile", "Backend", "C++", "Retrofit", "DataBinding", "Android", "Java"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        return inflater.inflate(R.layout.fragment_skill_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setListener()
    }


    private fun setRecyclerView() {
        listSkill.layoutManager = GridLayoutManager(context, columnCount)
        val adapter = SkillAdapter(skills)
        listSkill.adapter = adapter
        adapter.setOnItemClickListener { menuId , position, item, view ->
            when (menuId) {
                DELETE_ID -> {
                    //skills.removeAt(position)
                    adapter.deleteItem(position)
                }
                DETAIL_ID -> {
                    Toast.makeText(requireContext(), "position: $position, itemName: $item", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setListener() {
        fbAddSkill.setOnClickListener {
            showDialogToSetSkill() {
                Snackbar.make(requireActivity().findViewById(R.id.fragmentContainer), "You just added a new skill", Snackbar.LENGTH_LONG).setAction("UNDO") {
                    val removedItem = skills.size-1
                    skills.removeAt(removedItem)
                    listSkill.adapter?.notifyItemRemoved(removedItem)
                }
                .show()
            }
        }
    }

    private fun showDialogToSetSkill(listener: () -> Unit) {
        val taskEditText = EditText(requireContext())
        val dialog: AlertDialog = AlertDialog.Builder(requireContext())
            .setTitle("Add a new skill")
            .setMessage("Which skill do you want to add?")
            .setView(taskEditText)
            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, which ->
                val skill = taskEditText.text.toString()
                skills.add(skill)
                listSkill.adapter?.notifyItemInserted(skills.size)
                listener.invoke()
                dialog.dismiss()
            })
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }



    companion object {
        fun newInstance() = SkillListFragment()
        const val DELETE_ID = 1
        const val DETAIL_ID = 2
    }
}