package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        //getting input data from the user
        val car_price = editTextCarPrice.text.toString().toInt()
        val down_payment = editTextDownPayment.text.toString().toInt()
        val loan_period = editTextLoanPeriod.text.toString().toInt()
        val interest_rate = editTextInterestRate.text.toString().toFloat()

        val loan = car_price - down_payment
        textViewCarLoan.text = getString(R.string.car_loan)+": ${loan}"
        val interest = loan*interest_rate*loan_period
        textViewInterest.text=getString(R.string.interest)+": ${interest}"
        val mPayment = (loan+interest)/loan_period/12
        textViewMonthlyPayment.text = getString(R.string.monthly_payment)+": ${mPayment}"
    }
    fun resetInput(view: View){
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()
        textViewCarLoan.text = String.format("%s",getString(R.string.car_loan))
        textViewInterest.text = String.format("%s",getString(R.string.interest))
        textViewMonthlyPayment.text = String.format("%s",getString(R.string.monthly_payment))

    }
}
