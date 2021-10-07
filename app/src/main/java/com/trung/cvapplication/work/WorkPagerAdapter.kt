package com.trung.cvapplication.work

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.trung.cvapplication.work.skilllist.SkillListFragment
import com.trung.cvapplication.work.worklist.WorkListFragment

class WorkPagerAdapter(fm : FragmentManager, lc : Lifecycle) : FragmentStateAdapter (fm, lc){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->  WorkListFragment.newInstance()
            1 ->  SkillListFragment.newInstance()
            else-> Fragment()
        }
    }
}