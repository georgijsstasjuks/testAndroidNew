package com.example.training.kotlin.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.training.R
import com.example.training.kotlin.todolist.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoAdapter(private val todos: MutableList<Todo>): RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int { return todos.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {holder.setup(todos[position])}

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun removeTodo() {
        todos.removeAll{ todo -> todo.checked }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setup(item: Todo) {
            itemView.tvTodoTitle.text = item.title
            itemView.cbDone.isChecked = item.checked
            itemView.cbDone.setOnCheckedChangeListener { _, _ -> item.checked = !item.checked }
        }
    }

}