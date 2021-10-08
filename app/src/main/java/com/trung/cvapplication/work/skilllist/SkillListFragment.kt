package com.trung.cvapplication.work.skilllist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.trung.cvapplication.R
import com.trung.cvapplication.model.local.Skill
import com.trung.cvapplication.model.placeholder.SkillPlaceholderContent
import kotlinx.android.synthetic.main.fragment_skill_list.*



/**
 * A fragment representing a list of Items.
 */
class SkillListFragment : Fragment() {

    private var columnCount = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setListener()
    }


    private fun setRecyclerView() {
        listSkill.layoutManager = GridLayoutManager(context, columnCount)
        listSkill.adapter = SkillAdapter(SkillPlaceholderContent.ITEMS)

    }

    private fun setListener() {
        fbAddSkill.setOnClickListener {
            SkillPlaceholderContent.addLatestItem(Skill((SkillPlaceholderContent.ITEMS.size + 1).toString(), "Skill ${SkillPlaceholderContent.ITEMS.size+1}", ""))
            listSkill.adapter?.notifyItemInserted(SkillPlaceholderContent.ITEMS.size)

            Snackbar.make(requireActivity().findViewById(R.id.fragmentContainer), "You just added a new skill", Snackbar.LENGTH_LONG)
                .setAction("UNDO") {
                    SkillPlaceholderContent.removeLatestItem()
                    listSkill.adapter?.notifyItemRemoved(SkillPlaceholderContent.ITEMS.size)
                }
                .show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillListFragment()
    }
}