package com.example.mappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

//Autor:
//Oswaldo Félix Sánchez
//Iconos https://iconos8.es/icons/set/google
/*
https://stackoverflow.com/questions/10243557/how-to-apply-slide-animation-between-two-activities-in-android
Animaciones entre pantallas
*/

class MainActivity : AppCompatActivity() {

    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Checks google firebaseAnalytics working as intended
        firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        bundle.putString("message", "Integración con firebase exitosa")
        firebaseAnalytics.logEvent("InitScreen", bundle)
        /* Button start login activity */
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(this, Activitylogin::class.java))
        }
        /* Button start register activity */
        val btnRegister : Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, ActivityRegister::class.java))
        }
    }
}