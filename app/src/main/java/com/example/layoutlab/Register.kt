package com.example.layoutlab

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layoutlab.FirebaseFunctions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Register : AppCompatActivity() {
    private lateinit var FirebaseFunc: FirebaseFunctions
    private  lateinit var auth: FirebaseAuth

    lateinit var etx_username: EditText
    lateinit var etx_email: EditText
    lateinit var etx_password: EditText
    lateinit var btn_register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        FirebaseFunc = FirebaseFunctions()
        etx_username = findViewById(R.id.etx_usernameRegister)
        etx_email = findViewById(R.id.etx_emailRegister)
        etx_password = findViewById(R.id.etx_passwordRegister)
        btn_register = findViewById(R.id.btn_register)

        btn_register.setOnClickListener{

        }

    }

    fun register(username: String, email: String, password: String){
        
    }
}