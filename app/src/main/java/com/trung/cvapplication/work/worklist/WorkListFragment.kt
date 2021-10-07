package com.trung.cvapplication.work.worklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.trung.cvapplication.R
import com.trung.cvapplication.model.placeholder.WorkPlaceholderContent
import kotlinx.android.synthetic.main.fragment_work_list.*

/**
 * A fragment representing a list of Items.
 */
class WorkListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        listWork.layoutManager = LinearLayoutManager(context)
        listWork.adapter = WorkAdapter(WorkPlaceholderContent.ITEMS)

    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkListFragment()
    }
}