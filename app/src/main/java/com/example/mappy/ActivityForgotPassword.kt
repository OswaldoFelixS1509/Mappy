package com.example.mappy

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

lateinit var auth : FirebaseAuth

class ActivityForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        auth = Firebase.auth

        val btn : Button = findViewById(R.id.btnPasswordRecovery)
        btn.setOnClickListener {
            if(findViewById<EditText>(R.id.txtForgotPass).text.toString().isEmpty())
            {
                Toast.makeText(this, "Campo de texto vacio", Toast.LENGTH_SHORT).show()
            }
            else
            {
                sendEmail()
            }
        }

    }
    private fun sendEmail()
    {
        val email = findViewById<EditText>(R.id.txtForgotPass).text.toString()
        val builder = AlertDialog.Builder(this)
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener{
                task ->
                if(task.isSuccessful)
                {
                    builder.setTitle(R.string.dialogPassRecovery)
                    builder.setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialogInterface, i ->
                            finish()
                        })
                    builder.create()
                    builder.show()
                }
                else
                {
                    builder.setTitle(R.string.error)
                    builder.setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialogInterface, i ->
                        })
                    builder.create()
                    builder.show()
                }
            }
    }
}