package com.example.mappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.WindowManager

//Autor:
//Oswaldo Félix Sánchez
@Suppress("DEPRECATION")
class Activity_SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Esconde la status bar y muestra
        //el splash screen como pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Utilizamos el metodo PostDelayed(Runnable, time)
        //para enviar un mensaje con delay
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //Esto es el tiempo con delay en milisegundos
    }
}