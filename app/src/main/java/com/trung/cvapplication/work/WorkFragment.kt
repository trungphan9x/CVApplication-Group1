package com.trung.cvapplication.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.material.tabs.TabLayoutMediator
import com.trung.cvapplication.R
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
    }

    private fun setViewPager() {
        val adapter = WorkPagerAdapter(childFragmentManager,lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "WORK LIST"
                    tab.setIcon(R.drawable.ic_work_list)
                }
                1 -> {
                    tab.text = "SKILL LIST"
                    tab.setIcon(R.drawable.ic_skill_list)
                }
            }
        }.attach()

    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkFragment()
    }
}