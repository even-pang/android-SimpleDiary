package com.pang.simple_diary

import androidx.appcompat.widget.Toolbar

class Tab1(private val toolbar: Toolbar) {
    init {
        toolbar.title = "Tab1"

    }

    fun bar() = toolbar
}