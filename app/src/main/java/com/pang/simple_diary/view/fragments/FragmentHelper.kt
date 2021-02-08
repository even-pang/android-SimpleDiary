package com.pang.simple_diary.view.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.pang.simple_diary.R
import kotlin.properties.Delegates

class FragmentHelper(private val manager: FragmentManager) {
    fun fragChange(containerViewId: Int, fragment: Fragment) {
        manager.beginTransaction().replace(containerViewId, fragment).commit()
    }
}