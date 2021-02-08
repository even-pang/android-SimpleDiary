package com.pang.simple_diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pang.simple_diary.view.fragments.CalendarFragment
import com.pang.simple_diary.view.fragments.FragmentHelper
import com.pang.simple_diary.view.fragments.ListFragment
import com.pang.simple_diary.view.fragments.StatisticsFragment

class MainActivity : AppCompatActivity() {
    private val bar by lazy { supportActionBar!! }
    private val toolbar: Toolbar by lazy { findViewById(R.id.main_toolbar) }
    private val navBar: BottomNavigationView by lazy { findViewById(R.id.main_navigation) }
    private val fragHelper: FragmentHelper by lazy { FragmentHelper(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        init()
    }

    private fun init() {
        createBottomNavBar()
    }

    private fun createBottomNavBar() {
        navBar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_calendar -> {
                    fragHelper.fragChange(R.id.main_fragment, CalendarFragment())
                    setSupportActionBar(Tab1(toolbar).bar())
                }
                R.id.action_list -> {
                    fragHelper.fragChange(R.id.main_fragment, ListFragment())
                    setSupportActionBar(Tab2(toolbar).bar())
                }
                R.id.action_statistics -> {
                    fragHelper.fragChange(R.id.main_fragment, StatisticsFragment())
                    setSupportActionBar(Tab3(toolbar).bar())
                }
            }
            true
        }
        navBar.selectedItemId = R.id.action_calendar
    }
}