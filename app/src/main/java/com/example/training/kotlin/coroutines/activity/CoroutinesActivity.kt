package com.example.training.kotlin.coroutines.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.training.R
import com.example.training.kotlin.coroutines.services.CoroutineViewModel


class CoroutinesActivity : AppCompatActivity() {

    private val viewModel: CoroutineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.getAllData("ny")
        viewModel.repositories().observe(this) {
            Log.e("CoroutinesActivity", it.toString())
        }
    }
}