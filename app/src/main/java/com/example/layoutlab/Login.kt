package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.layoutlab.FirebaseFunctions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {
    private lateinit var FirebaseFunc: FirebaseFunctions
    private  lateinit var auth: FirebaseAuth

    lateinit var etx_email: EditText
    lateinit var etx_password: EditText
    lateinit var btn_login: Button
    lateinit var txt_goToRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)



        etx_email = findViewById(R.id.etx_emailLogin)
        etx_password = findViewById(R.id.etx_passwordLogin)
        btn_login = findViewById(R.id.btn_login)
        txt_goToRegister = findViewById(R.id.txt_goToRegister)

        txt_goToRegister.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
            finish()
        }

        btn_login.setOnClickListener{
            login()
        }

    }

    fun login(){
        val email = etx_email.text.toString()
        val password = etx_password.text.toString()

        FirebaseFunc = FirebaseFunctions()

        FirebaseFunc.loginUser(email, password){ success, message ->
            if (success) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed: $message", Toast.LENGTH_SHORT).show()
            }
        }

        val intent = Intent(this@Login, Home::class.java)
        startActivity(intent)
        finish()

    }
}