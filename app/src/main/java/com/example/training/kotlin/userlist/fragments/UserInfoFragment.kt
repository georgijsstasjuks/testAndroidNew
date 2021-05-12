package com.example.training.kotlin.userlist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.training.R
import com.example.training.kotlin.userlist.model.User
import com.example.training.kotlin.userlist.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_user_info.*

class UserInfoFragment : Fragment() {

    companion object {
        const val TAG = "UserInfoFragment"
        const val NAME = "NAME"
        const val DESCRIPTION = "DESCRIPTION"
    }

    private val users = listOf(
            User("John", "Snow"),
            User("Test", "Some random and useless text"),
            User("Random", "Text"),
            User("White", "Nigger"),
            User("One", "More")
    )

    private val adapter = RecyclerAdapter(users)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.onClick = {
            val userDetails = UserDetailsFragment()
            val bundle = Bundle()
            bundle.putString(NAME, it.name)
            bundle.putString(DESCRIPTION, it.description)
            userDetails.arguments = bundle
            parentFragmentManager.beginTransaction()
                    .addToBackStack(UserDetailsFragment.TAG)
                    .add(R.id.fragment_container, userDetails)
                    .commit()
        }
        recyclerView.adapter = adapter
    }

}