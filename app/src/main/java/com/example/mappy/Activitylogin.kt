package com.example.mappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.app.ProgressDialog
import android.widget.*

class Activitylogin : AppCompatActivity() {


    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Initialize firebase and google services
        auth = Firebase.auth
        //Button event to go back
        val btnBack : ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        //Button event to login
        val btnLogin : Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            login()
        }
        val btnForgotPass : TextView = findViewById(R.id.txtvForgotPass)
        btnForgotPass.setOnClickListener {
            startActivity(Intent(this, ActivityForgotPassword::class.java))
        }
    }
    fun login()
    {
        //This code shows a dialog while we try to login
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Intentando acceder a tu cuenta")
        progressDialog.setMessage("La aplicación esta cargando, por favor espera un momento")
        progressDialog.show()
        //Toast.makeText(this,"Texto de ejemplo", Toast.LENGTH_SHORT)
        //Checks if textBox are empty, if not tries to login
        if(findViewById<EditText>(R.id.txtEmail).text.toString().isEmpty() || findViewById<EditText>(R.id.txtPass).text.toString().isEmpty())
        {
            //Hides progressDialog and displays a message to the user. Then change borderline color to red
            progressDialog.hide()
            Toast.makeText(this, "Un campo de texto se encuentra vacio", Toast.LENGTH_SHORT).show()
            findViewById<EditText?>(R.id.txtEmail).setBackgroundResource(R.drawable.rounded_edittext_error)
            findViewById<EditText?>(R.id.txtPass).setBackgroundResource(R.drawable.rounded_edittext_error)
        }
        else
        {
            //Gets Email and pass from textBox, then uses google Auth to login
            val Email = findViewById<EditText>(R.id.txtEmail).text.toString()
            val Pass  = findViewById<EditText>(R.id.txtPass).text.toString()
            auth.signInWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener(this){
                        task ->
                    if(task.isSuccessful)
                    {
                        //If the login was successfuly sets borderline green, hides progress dialog and then start main menu activity
                        findViewById<EditText?>(R.id.txtEmail).setBackgroundResource(R.drawable.rounded_edittext)
                        findViewById<EditText?>(R.id.txtPass).setBackgroundResource(R.drawable.rounded_edittext)
                        progressDialog.hide()
                        startActivity(Intent(this, ActivityMainMenu::class.java))

                    }
                    else{
                        //If login had an error sets borderline red, hides progress dialog and sets a message for the user
                        findViewById<EditText?>(R.id.txtEmail).setBackgroundResource(R.drawable.rounded_edittext_error)
                        findViewById<EditText?>(R.id.txtPass).setBackgroundResource(R.drawable.rounded_edittext_error)
                        progressDialog.hide()
                        Toast.makeText(this, "Correo o contraseña incorrectos \n Intentalo de nuevo", Toast.LENGTH_SHORT).show() }
                }
        }
    }
}