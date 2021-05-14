package com.example.training.kotlin.enumclass

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.training.R
import kotlinx.android.synthetic.main.activity_time_check.*
import java.util.*

class TimeCheckActivity : AppCompatActivity() {
    private var hours: Int = 0
    private var minutes: Int = 0
    private var activity = this
    lateinit var timePicker: TimePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_check)
        setupVars()
        setupTimePicker()
        tvTime.setOnClickListener{ timePicker.show() }
    }

    private fun setupTimePicker() {
        timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            checkTime(hourOfDay)
        }, hours, minutes, true)
    }

    private fun setupVars() {
        val currentTime = Calendar.getInstance()
        hours = currentTime.get(Calendar.HOUR_OF_DAY)
        minutes = currentTime.get(Calendar.MINUTE)
    }

    private fun checkTime(hour: Int) {
        if (hour in 0..6) {
            Toast.makeText(activity, DayTime.NIGHT.getStatus(), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activity, DayTime.DAY.getStatus(), Toast.LENGTH_LONG).show()
        }
    }
}

