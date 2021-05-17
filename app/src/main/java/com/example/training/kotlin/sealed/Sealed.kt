package com.example.training.kotlin.sealed

sealed class Sealed {
    class Const(val number: Double) : Sealed()
    class Sum(val num1: Sealed, val num2: Sealed): Sealed()
    object NotANumber : Sealed()
}