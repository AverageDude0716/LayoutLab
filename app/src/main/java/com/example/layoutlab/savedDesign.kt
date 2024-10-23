package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class savedDesign : AppCompatActivity() {

    lateinit var btn_backSavedDesigns: Button
    lateinit var btn_profileSavedDesigns: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saved_design)

        btn_backSavedDesigns = findViewById(R.id.btn_backSavedDesigns)
        btn_profileSavedDesigns = findViewById(R.id.btn_profileSavedDesigns)

        btn_backSavedDesigns.setOnClickListener {
            val intent = Intent(this@savedDesign, Home::class.java)
            startActivity(intent)
            finish()
        }

        btn_profileSavedDesigns.setOnClickListener {
            val intent = Intent(this@savedDesign, profile::class.java)
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