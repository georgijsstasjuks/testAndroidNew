package com.example.training.kotlin.userlist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.training.R
import com.example.training.kotlin.userlist.fragments.UserInfoFragment

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        supportFragmentManager.beginTransaction()
                .addToBackStack(UserInfoFragment.TAG)
                .add(R.id.fragment_container, UserInfoFragment())
                .commit()
        val actionbar = supportActionBar
        actionbar?.hide()
    }

}