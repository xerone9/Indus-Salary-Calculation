package com.example.indussalary

import android.content.Intent
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.view.KeyEvent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_click_me    =   findViewById(R.id.button) as Button
        var btn2_click_me   =   findViewById(R.id.button2) as Button
        var salary          =   findViewById(R.id.salary) as EditText
        var deductiveHours  =   findViewById(R.id.dedutiveHours) as EditText
        var overtimesExtras =   findViewById(R.id.overtimesExtras) as EditText
        var anyLoan         =   findViewById(R.id.anyLoan) as EditText
        var absentDays      =   findViewById(R.id.absentDays) as EditText
        var extraDays       =   findViewById(R.id.extraDays) as EditText
        val textView1       =   findViewById(R.id.textView1) as TextView
        val textView2       =   findViewById(R.id.textView2) as TextView
        val textView3       =   findViewById(R.id.textView3) as TextView
        val textView4       =   findViewById(R.id.textView4) as TextView
        val textView5       =   findViewById(R.id.textView5) as TextView
        val textView6       =   findViewById(R.id.textView6) as TextView


        btn_click_me.setOnClickListener {
            if (salary.text.trim().length == 0) {

                textView1.setTextColor(getResources().getColor(R.color.red))
                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }

            }
            else {
                textView1.setTextColor(getResources().getColor(R.color.black))
            }

            if (deductiveHours.text.trim().length == 0) {

                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }
                textView2.setTextColor(getResources().getColor(R.color.red))

            }
            else {
                textView2.setTextColor(getResources().getColor(R.color.black))
            }

            if (overtimesExtras.text.trim().length == 0) {

                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }
                textView3.setTextColor(getResources().getColor(R.color.red))

            }
            else {
                textView3.setTextColor(getResources().getColor(R.color.black))
            }

            if (anyLoan.text.trim().length == 0) {

                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }
                textView4.setTextColor(getResources().getColor(R.color.red))

            }
            else {
                textView4.setTextColor(getResources().getColor(R.color.black))
            }

            if (absentDays.text.trim().length == 0) {

                textView5.setTextColor(getResources().getColor(R.color.red))
                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }

            }
            else {
                textView5.setTextColor(getResources().getColor(R.color.black))
            }

            if (salary.text.trim().length == 0) {

                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }
                textView1.setTextColor(getResources().getColor(R.color.red))

            }
            else {
                textView1.setTextColor(getResources().getColor(R.color.black))
            }

            if (extraDays.text.trim().length == 0) {

                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }
                textView6.setTextColor(getResources().getColor(R.color.red))

            }
            else {
                textView6.setTextColor(getResources().getColor(R.color.black))
            }




        if (salary.text.trim().length > 0 && deductiveHours.text.trim().length > 0 && overtimesExtras.text.trim().length > 0 && anyLoan.text.trim().length > 0 && absentDays.text.trim().length > 0 && extraDays.text.trim().length > 0) {
            val num1 = salary.text.toString().toFloat()
            val user1: Float = num1
            val num2 = deductiveHours.text.toString().toFloat()
            val user2: Float = num2
            val num3 = overtimesExtras.text.toString().toFloat()
            val user3: Float = num3
            val num4 = anyLoan.text.toString().toFloat()
            val user4: Float = num4
            val num5 = absentDays.text.toString().toFloat()
            val user5: Float = num5
            val num6 = extraDays.text.toString().toFloat()
            val user6: Float = num6
            val salaryA = (user1 * 12 / 365 * user3) / 10  // over time
            val salaryB = ((user1 * 12 / 365 * user2) / 10) /60 // deductive minutes
            val salaryC = user1 * 12 / 365 * user5 // absent days
            val salaryD = user1 * 12 / 365 * user6 // extra days
            val salaryX = salaryA - salaryB + user1 - user4 - salaryC + salaryD
            //val salaryZ = salaryX.toString()
            val dec = DecimalFormat("###,###")
            val salaryZ = dec.format(salaryX)

            //KeyEvent.KEYCODE_ENTER.Toast.makeText(HelloFormStuff.this, edittext.getText(), Toast.LENGTH_SHORT).show();

            textView1.setTextColor(getResources().getColor(R.color.black))
            textView2.setTextColor(getResources().getColor(R.color.black))
            textView3.setTextColor(getResources().getColor(R.color.black))
            textView4.setTextColor(getResources().getColor(R.color.black))
            textView5.setTextColor(getResources().getColor(R.color.black))
            textView6.setTextColor(getResources().getColor(R.color.black))
            findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }
            findViewById<TextView>(R.id.textSalary).apply {
                text = "Your Salary Will be $salaryZ (approximate)"
            }


        }
            else
            {
                Toast.makeText(this, "Enter All Values (enter 0 for blank fields)", Toast.LENGTH_LONG).show()
            }

            extraDays.setOnKeyListener { _, keyCode, keyEvent ->
                if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                    btn_click_me.performClick()


                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }

        }

            btn2_click_me.setOnClickListener {

                salary.requestFocus()
                findViewById<EditText>(R.id.salary).text.clear()
                findViewById<EditText>(R.id.dedutiveHours).text.clear()
                findViewById<EditText>(R.id.overtimesExtras).text.clear()
                findViewById<EditText>(R.id.anyLoan).text.clear()
                findViewById<EditText>(R.id.absentDays).text.clear()
                findViewById<EditText>(R.id.extraDays).text.clear()
                findViewById(R.id.textView1) as TextView
                textView1.setTextColor(getResources().getColor(R.color.black))
                textView2.setTextColor(getResources().getColor(R.color.black))
                textView3.setTextColor(getResources().getColor(R.color.black))
                textView4.setTextColor(getResources().getColor(R.color.black))
                textView5.setTextColor(getResources().getColor(R.color.black))
                textView6.setTextColor(getResources().getColor(R.color.black))
                findViewById<TextView>(R.id.textSalary).apply { text = "Calculate Your Salary" }



            }






        salary.setOnClickListener {


              findViewById<TextView>(R.id.textSalary).apply { text= "Calculate Your Salary" }

            }

        deductiveHours.setOnClickListener {


              findViewById<TextView>(R.id.textSalary).apply { text= "Calculate Your Salary" }

        }

        overtimesExtras.setOnClickListener {


            findViewById<TextView>(R.id.textSalary).apply { text= "Calculate Your Salary" }

        }

        anyLoan.setOnClickListener {


            findViewById<TextView>(R.id.textSalary).apply { text= "Calculate Your Salary" }

        }

        absentDays.setOnClickListener {


            findViewById<TextView>(R.id.textSalary).apply { text= "Calculate Your Salary" }

        }

        extraDays.setOnClickListener {


            findViewById<TextView>(R.id.textSalary).apply { text= "Calculate Your Salary" }

        }


    }

}
