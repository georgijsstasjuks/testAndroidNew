package com.example.training.kotlin.extensionfunc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.training.R
import kotlinx.android.synthetic.main.activity_count_letter.*

class CountLetterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_letter)
        setupListeners()
    }

    private fun setupListeners() {
        btSendInt.setOnClickListener {
            val number = etInt.text.toString()
            tvAnswer.text = number.toInt().square().toString()
        }

        btSendString.setOnClickListener {
            val word = etString.text.toString()
            val letter = etLetter.text
            tvAnswer.text = word.countLetter(letter.toString().toCharArray()).toString()
        }
    }

    private fun String.countLetter(c: CharArray) : Int{
        var count = 0
        for (n in 0 until this.count()) {
            if(this[n].toLowerCase() == c[0].toLowerCase()) count++
        }
        return count
    }

    private fun Int.square(): Int { return this * this }

}