package com.example.training.kotlin.nullsafety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.training.R
import kotlinx.android.synthetic.main.activity_count_length.*

class CountLengthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_length)
        setupListener()
    }

    private fun setupListener() {
        btSendWord.setOnClickListener{
            val str: String? = getEditTextString()
            Toast.makeText(this, str!!.length.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun getEditTextString(): String? = etWordToCount.text.toString()

}