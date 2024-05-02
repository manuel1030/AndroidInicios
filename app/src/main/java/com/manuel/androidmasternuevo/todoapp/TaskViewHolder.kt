package com.manuel.androidmasternuevo.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.manuel.androidmasternuevo.R

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTack: CheckBox = view.findViewById(R.id.cbTask)
    fun render(task: Task) {
        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbTack.isChecked = task.isSelected
        tvTask.text = task.name
        val color = when (task.Category) {
            TaskCategory.Personal -> {
                R.color.todo_personal_category
            }

            TaskCategory.Business -> {
                R.color.todo_business_category
            }

            TaskCategory.Other -> {
                R.color.todo_other_category
            }
        }
        cbTack.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTack.context, color)
        )

    }
}