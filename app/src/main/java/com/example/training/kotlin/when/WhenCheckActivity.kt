package com.example.training.kotlin.`when`

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.training.R
import kotlinx.android.synthetic.main.activity_when_check.*

class WhenCheckActivity : AppCompatActivity() {
    lateinit var number: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_when_check)

        btSubmit.setOnClickListener{
            number = etNumber.text.toString()
            when {
                number.toInt() < 50 -> Toast.makeText(this, "number is too small", Toast.LENGTH_LONG).show()
                number.toInt() > 100 -> Toast.makeText(this, "number is too big", Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this, "normal number", Toast.LENGTH_LONG).show()
            }
        }
    }
}