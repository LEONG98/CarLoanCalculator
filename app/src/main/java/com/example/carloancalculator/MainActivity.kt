package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
            calLoan()
        }
    }

    private fun calLoan(){
        val carPrice:Double = txtCarPrice.text.toString().toDouble()
        val downPayment:Double = txtDownPayment.text.toString().toDouble()
        val period:Double = txtLoanPeriod.text.toString().toDouble()
        val interestRate:Double = txtInterestRate.text.toString().toDouble()

        val carLoan:Double = carPrice - downPayment
        val interest:Double = carLoan * (interestRate/100) * period
        val monthly = (carLoan + interest) / period / 12

        viewCarLoan.text = "RM %.2f".format(carLoan)
        viewCarInterest.text = "RM %.2f".format(interest)
        viewMonthly.text = "RM %.2f".format(monthly)
    }
}
