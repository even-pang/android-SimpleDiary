package com.pang.simple_diary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pang.simple_diary.R
import com.pang.simple_diary.view.fragment.CalendarFragment
import com.pang.simple_diary.control.MainPagerAdapter
import com.pang.simple_diary.view.fragment.ListFragment
import com.pang.simple_diary.view.fragment.StatisticsFragment

class MainActivity : AppCompatActivity() {
    private val navBar: BottomNavigationView by lazy { findViewById(R.id.main_navigation) }
    private val pagerScreen: ViewPager2 by lazy { findViewById(R.id.main_pager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        createPagerScreen()
        createBottomNavBar()
    }

    private fun createPagerScreen() {
        val adapter = MainPagerAdapter(arrayListOf(CalendarFragment(), ListFragment(), StatisticsFragment()), this)
        pagerScreen.adapter = adapter
        pagerScreen.isUserInputEnabled = false
    }

    private fun createBottomNavBar() {
        navBar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_calendar -> {
                    pagerScreen.currentItem = 0
                }
                R.id.action_list -> {
                    pagerScreen.currentItem = 1
                }
                R.id.action_statistics -> {
                    pagerScreen.currentItem = 2
                }
            }
            true
        }
        navBar.selectedItemId = R.id.action_calendar
    }
}