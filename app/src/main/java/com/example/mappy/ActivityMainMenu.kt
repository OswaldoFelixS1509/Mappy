package com.example.mappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityMainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val user = Firebase.auth.currentUser
        val txtUser : TextView = findViewById(R.id.txtUser)
        txtUser.text = user?.email.toString()

    }
}