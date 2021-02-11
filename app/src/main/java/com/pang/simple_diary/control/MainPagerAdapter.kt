package com.pang.simple_diary.control

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(private val tabs: ArrayList<Fragment>, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = tabs.size
    override fun createFragment(position: Int): Fragment = tabs[position]
}