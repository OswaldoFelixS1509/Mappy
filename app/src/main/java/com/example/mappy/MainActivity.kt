package com.example.mappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//Autor:
//Oswaldo Félix Sánchez
//Iconos https://iconos8.es/icons/set/google
/*
https://stackoverflow.com/questions/10243557/how-to-apply-slide-animation-between-two-activities-in-android
Animaciones entre pantallas
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {

            val intent = Intent(this, Activity_login::class.java)
            startActivity(intent)
        }
    }
}