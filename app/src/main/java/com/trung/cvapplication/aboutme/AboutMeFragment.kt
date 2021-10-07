package com.trung.cvapplication.aboutme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trung.cvapplication.R

class AboutMeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_me, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = AboutMeFragment()
    }
}