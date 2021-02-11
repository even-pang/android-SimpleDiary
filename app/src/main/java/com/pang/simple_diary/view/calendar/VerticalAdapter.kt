package com.pang.simple_diary.view.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pang.simple_diary.R
import com.pang.simple_diary.constant.ConstInt
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class VerticalAdapter(private val inner: Int): RecyclerView.Adapter<VerticalAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tv: TextView = itemView.findViewById(R.id.calendar_text)
        fun bind(position: Int) {
            val now = Calendar.getInstance()
            now.add(Calendar.MONTH, (inner - ConstInt.CENTER_OF_INT) + (position - ConstInt.CENTER_OF_INT) * 12)
            val date = SimpleDateFormat("yyyy-MM", Locale.getDefault())

            val string = StringBuilder()

            string.append(date.format(now.time))
            string.append("\n\nX : ${inner - ConstInt.CENTER_OF_INT}\nY : ${position - ConstInt.CENTER_OF_INT}")
            tv.text = string
        }
    }

    companion object {
        var POSITION: Int = ConstInt.CENTER_OF_INT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.calendar_vertical, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = Integer.MAX_VALUE
}