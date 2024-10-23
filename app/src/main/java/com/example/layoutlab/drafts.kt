package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class drafts : AppCompatActivity() {

    lateinit var btn_backDrafts: Button
    lateinit var btn_profileDrafts: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drafts)

        btn_backDrafts = findViewById(R.id.btn_backDrafts)
        btn_profileDrafts = findViewById(R.id.btn_profileDrafts)

        btn_backDrafts.setOnClickListener {
            val intent = Intent(this@drafts, Home::class.java)
            startActivity(intent)
            finish()
        }

        btn_profileDrafts.setOnClickListener {
            val intent = Intent(this@drafts, profile::class.java)
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