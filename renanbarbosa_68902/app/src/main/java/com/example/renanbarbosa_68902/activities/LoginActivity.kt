package com.example.renanbarbosa_68902.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.renanbarbosa_68902.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    var email: EditText? = null
    var password: EditText? = null
    var login: MaterialButton? = null
    var signup: TextView? = null
    var database: FirebaseDatabase? = null
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        signup = findViewById(R.id.registerLink)
        password = findViewById(R.id.passwordEditText)
        email = findViewById(R.id.emailEditText)
        login = findViewById(R.id.loginBtn)
        signup?.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    SignupActivity::class.java
                )
            )
        })
        login?.setOnClickListener(View.OnClickListener { loginUser() })
    }

    private fun loginUser() {
        val userEmail = email!!.text.toString()
        val userPassword = password!!.text.toString()
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "Email is empty.", Toast.LENGTH_SHORT).show()
        }
        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "Password is empty.", Toast.LENGTH_SHORT).show()
        }
        auth!!.signInWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@LoginActivity, "Logged In Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    Toast.makeText(this@LoginActivity, "Error: " + task.exception, Toast.LENGTH_SHORT).show()
                }
            }
    }
}