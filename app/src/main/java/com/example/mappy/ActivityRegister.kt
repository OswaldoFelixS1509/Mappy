package com.example.mappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class ActivityRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //This event finish current screen and go back
        val btnBack : ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }


    }
}
/*
    private fun onDateSelected() {

        //This code block verifies if the user is 18 or older

        val c1 = Calendar.getInstance ();
        c1.set(year, month - 1, day, 0, 0); // as MONTH in calender is 0 based.

        val c2 = Calendar.getInstance();
        var diff = c2.get (Calendar.YEAR) - c1.get(Calendar.YEAR);
        if (c1.get(Calendar.MONTH) > c2.get(Calendar.MONTH) ||
            (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DATE) > c2.get(
                Calendar.DATE
            ))
        ) {
            diff--;
        }

*/