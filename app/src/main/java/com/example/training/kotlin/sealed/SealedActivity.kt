package com.example.training.kotlin.sealed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.training.R

class SealedActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LOG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed)
        val num1 = Sealed.Const(1.2)
        val num2 = Sealed.Const(2.2)
        val sum = Sealed.Sum(num1, num2)
        Log.e(TAG, eval(sum).toString())
    }

    private fun eval(expr: Sealed): Double = when(expr){
        is Sealed.Const -> expr.number
        is Sealed.Sum ->eval(expr.num1) + eval(expr.num2)

        Sealed.NotANumber -> Double.NaN
    }

}