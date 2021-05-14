package com.example.training.kotlin.enumclass

enum class DayTime: Printable {
    DAY {
        override fun getStatus(): String {
            return "Now it's day time"
        }
    },
    NIGHT{
        override fun getStatus(): String {
            return "Now it's night"
        }
    }
}