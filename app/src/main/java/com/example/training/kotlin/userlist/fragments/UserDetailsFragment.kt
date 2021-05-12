package com.example.training.kotlin.userlist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.training.R
import com.example.training.kotlin.userlist.fragments.UserInfoFragment.Companion.DESCRIPTION
import com.example.training.kotlin.userlist.fragments.UserInfoFragment.Companion.NAME
import kotlinx.android.synthetic.main.fragment_user_details.*

class UserDetailsFragment : Fragment() {

    companion object {
        const val TAG = "UserDetailsFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name.text = arguments?.getString(NAME)
        description.text = arguments?.getString(DESCRIPTION)
        backButton.setOnClickListener { requireActivity().onBackPressed()}
    }

}