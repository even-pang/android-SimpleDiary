package com.pang.simple_diary

import androidx.appcompat.widget.Toolbar

class Tab2(private val toolbar: Toolbar) {
    init {
        toolbar.title = "Tab2"

    }

    fun bar() = toolbar
}