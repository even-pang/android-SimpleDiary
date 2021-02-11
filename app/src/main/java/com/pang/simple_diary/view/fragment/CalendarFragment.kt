package com.pang.simple_diary.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.pang.simple_diary.R
import com.pang.simple_diary.constant.ConstInt
import com.pang.simple_diary.view.calendar.HorizontalAdapter

class CalendarFragment: Fragment() {
    companion object {
        val name = CalendarFragment::class.simpleName!!
    }
    private lateinit var calendarPager: ViewPager2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        init(view)

        return view
    }

    private fun init(view: View) {
        val adapter = HorizontalAdapter()
        calendarPager = view.findViewById(R.id.frag_calendar_pager)
        calendarPager.adapter = adapter
        calendarPager.setCurrentItem(ConstInt.CENTER_OF_INT, false)
    }
}