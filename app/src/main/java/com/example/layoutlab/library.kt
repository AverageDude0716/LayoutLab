package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class library : AppCompatActivity() {

    lateinit var btn_backLibrary: Button
    lateinit var btn_profileLibrary: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_library)

        btn_backLibrary = findViewById(R.id.btn_backLibrary)
        btn_profileLibrary = findViewById(R.id.btn_profileLibrary)

        btn_backLibrary.setOnClickListener {
            val intent = Intent(this@library, Home::class.java)
            startActivity(intent)
            finish()
        }

        btn_profileLibrary.setOnClickListener {
            val intent = Intent(this@library, profile::class.java)
            startActivity(intent)
            finish()
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}