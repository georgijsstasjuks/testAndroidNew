package com.example.training.kotlin.userlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.training.R
import com.example.training.kotlin.userlist.model.User
import kotlinx.android.synthetic.main.user_item_layout.view.*

class RecyclerAdapter(private val userList: List<User>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var onClick: (User) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int { return userList.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.setup(user)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setup(user: User) {
            itemView.titleCard.text = user.name
            itemView.descriptionCard.text = user.description
            itemView.setOnClickListener { onClick.invoke(user) }
        }
    }

}


