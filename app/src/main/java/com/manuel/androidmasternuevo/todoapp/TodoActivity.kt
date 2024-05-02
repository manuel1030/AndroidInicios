package com.manuel.androidmasternuevo.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.manuel.androidmasternuevo.R
import com.manuel.androidmasternuevo.todoapp.TaskCategory.*
import java.text.FieldPosition

class TodoActivity : AppCompatActivity() {
    private val categories = listOf(
        Business,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaBusiness1", Personal),
        Task("PruebaBusiness2", Other)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvtTasks: RecyclerView
    private lateinit var tasksAdapater: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvtTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)

    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {position -> updateCategories(position)}
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapater = TasksAdapter(tasks) {position -> onItemSelected(position)}
        rvtTasks.layoutManager = LinearLayoutManager(this)
        rvtTasks.adapter = tasksAdapater

    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_task_business) -> Business
                    getString(R.string.todo_task_personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(etTask.text.toString(), currentCategory))
                updateTasks()
                dialog.hide()
            }

        }

        dialog.show()
    }

    private fun updateTasks() {
        val selectedCategories : List<TaskCategory> = categories.filter { it.isSelect }
        val newTasks = tasks.filter { selectedCategories.contains(it.Category) }
        tasksAdapater.tasks = newTasks;
        tasksAdapater.notifyDataSetChanged()
    }
    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }
    private fun updateCategories(position : Int){
        categories[position].isSelect = !categories[position].isSelect
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }
}