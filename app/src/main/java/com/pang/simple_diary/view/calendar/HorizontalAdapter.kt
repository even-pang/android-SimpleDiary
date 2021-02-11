package com.pang.simple_diary.view.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.pang.simple_diary.R
import com.pang.simple_diary.constant.ConstInt

class HorizontalAdapter: RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val innerPager: ViewPager2 = itemView.findViewById(R.id.calendar_pager)
        fun bind(position: Int) {
            innerPager.adapter = VerticalAdapter(position)
            innerPager.orientation = ViewPager2.ORIENTATION_VERTICAL
            innerPager.setCurrentItem(VerticalAdapter.POSITION, false)
            innerPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    VerticalAdapter.POSITION = position
                }
            })
        }
        fun repos() { innerPager.setCurrentItem(VerticalAdapter.POSITION, false) }
    }

    private fun init() {
        VerticalAdapter.POSITION = ConstInt.CENTER_OF_INT
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        holder.repos()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        init()
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.calendar_horizontal, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = Integer.MAX_VALUE
}