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

class Register : AppCompatActivity() {
    private lateinit var FirebaseFunc: FirebaseFunctions
    private  lateinit var auth: FirebaseAuth

    lateinit var etx_username: EditText
    lateinit var etx_email: EditText
    lateinit var etx_password: EditText
    lateinit var btn_register: Button
    lateinit var etx_confirmPassword: EditText
    lateinit var txt_goToLogin: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        //FirebaseFunc = FirebaseFunctions()
        etx_username = findViewById(R.id.etx_usernameRegister)
        etx_email = findViewById(R.id.etx_emailRegister)
        etx_password = findViewById(R.id.etx_passwordRegister)
        btn_register = findViewById(R.id.btn_register)
        txt_goToLogin = findViewById(R.id.txt_gotToLogin)
        etx_confirmPassword = findViewById(R.id.etx_confirmPasswordRegister)

        btn_register.setOnClickListener{
            register()
        }

        txt_goToLogin.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun register(){
        FirebaseFunc = FirebaseFunctions()

        val username = etx_username.text.toString()
        val email = etx_email.text.toString()
        val password = etx_password.text.toString()
        val confirmPassword = etx_confirmPassword.text.toString()

        if (email.isBlank() || password.isBlank() || username.isBlank()) {
            Toast.makeText(this, "Username, Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (password == confirmPassword) {
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
            return
        }

        val user = hashMapOf(
            "username" to username,
            "email" to email
        )

        FirebaseFunc.registerUser(email, password) { success, message ->
            if (success) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                lifecycleScope.launch {
                    val saved = FirebaseFunc.saveUserData("User", user)
                    if(saved){
                        Toast.makeText(this@Register, "Data Saved Successfully", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@Register, Home::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this@Register, "Failed to Save Data", Toast.LENGTH_SHORT).show()
                    }

                }

            } else {
                Toast.makeText(this, "Registration Failed: $message", Toast.LENGTH_SHORT).show()
            }
        }

    }
}