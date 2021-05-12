package com.example.training.kotlin.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.training.R
import com.example.training.kotlin.todolist.adapter.TodoAdapter
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        setupAdapter()
        setupListeners()
    }

    fun setupAdapter() {
        todoAdapter = TodoAdapter(mutableListOf())
        rvTodo.adapter = todoAdapter
        rvTodo.layoutManager = LinearLayoutManager(this)
    }

    fun setupListeners() {
        btAdd.setOnClickListener {
            val title = etTodoTitle.text.toString()
            if (title.isNotEmpty()) {
                val todo = Todo(title)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btRemove.setOnClickListener {
            todoAdapter.removeTodo()
        }
    }

}