package com.example.calculator.viewmodel

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var sign: String = ""
    var firstValue: Float = 0.0f
    var secondValue: Float = 0.0f


    fun calculate() {
        when (sign) {
            "+" -> plus()
            "-" -> minus()
            "×" -> multiply()
            "÷" -> division()
        }
    }

    private fun plus() {
        firstValue += secondValue
    }

    private fun minus() {
        firstValue -= secondValue
    }

    private fun multiply() {
        firstValue *= secondValue
    }

    private fun division() {
            firstValue /= secondValue

    }

    fun clear() {
        firstValue = 0.0f
        secondValue = 0.0f
        sign = ""
    }

}