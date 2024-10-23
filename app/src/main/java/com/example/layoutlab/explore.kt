package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class explore : AppCompatActivity() {

    lateinit var btn_backExplore: Button
    lateinit var btn_profileExplore: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explore)

        btn_backExplore = findViewById(R.id.btn_backExplore)
        btn_profileExplore = findViewById(R.id.btn_profileExplore)

        btn_backExplore.setOnClickListener {
            val intent = Intent(this@explore, Home::class.java)
            startActivity(intent)
            finish()
        }

        btn_profileExplore.setOnClickListener {
            val intent = Intent(this@explore, profile::class.java)
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