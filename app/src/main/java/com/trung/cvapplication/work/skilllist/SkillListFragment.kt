package com.trung.cvapplication.work.skilllist

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trung.cvapplication.R
import kotlinx.android.synthetic.main.fragment_skill_list.*
import android.database.sqlite.SQLiteDatabase

import android.content.ContentValues

import android.content.DialogInterface
import android.view.WindowManager

import android.widget.EditText


/**
 * A fragment representing a list of Items.
 */
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
        listSkill.adapter = SkillAdapter(skills)

    }

    private fun setListener() {
//        fbAddSkill.setOnClickListener {
//            SkillPlaceholderContent.addLatestItem(Skill((SkillPlaceholderContent.ITEMS.size + 1).toString(), "Skill ${SkillPlaceholderContent.ITEMS.size+1}", ""))
//            listSkill.adapter?.notifyItemInserted(SkillPlaceholderContent.ITEMS.size)
//
//            Snackbar.make(requireActivity().findViewById(R.id.fragmentContainer), "You just added a new skill", Snackbar.LENGTH_LONG)
//                .setAction("UNDO") {
//                    SkillPlaceholderContent.removeLatestItem()
//                    listSkill.adapter?.notifyItemRemoved(SkillPlaceholderContent.ITEMS.size)
//                }
//                .show()
//        }

        fbAddSkill.setOnClickListener {
            showDialogToSetSkill()
        }
    }

    private fun showDialogToSetSkill() {
        val taskEditText = EditText(requireContext())
        val dialog: AlertDialog = AlertDialog.Builder(requireContext())
            .setTitle("Add a new skill")
            .setMessage("Which skill do you want to add?")
            .setView(taskEditText)
            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, which ->
                val skill = taskEditText.text.toString()
                skills.add(skill)
                listSkill.adapter?.notifyItemInserted(skills.size)
                dialog.dismiss()
            })
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }



    companion object {
        @JvmStatic
        fun newInstance() = SkillListFragment()
    }
}