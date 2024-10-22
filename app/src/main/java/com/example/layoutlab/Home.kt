package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Home : AppCompatActivity() {

    lateinit var btn_settingsHome: Button
    lateinit var btn_profileHome: Button
    lateinit var lin_savedDesigns: LinearLayout
    lateinit var lin_drafts: LinearLayout
    lateinit var lin_library: LinearLayout
    lateinit var lin_explore: LinearLayout
    lateinit var fab_addHome: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        btn_settingsHome = findViewById(R.id.btn_settingsHome)
        btn_profileHome = findViewById(R.id.btn_profileHome)
        lin_savedDesigns = findViewById(R.id.lin_savedDesigns)
        lin_drafts = findViewById(R.id.lin_drafts)
        lin_library = findViewById(R.id.lin_library)
        lin_explore = findViewById(R.id.lin_explore)
        fab_addHome = findViewById(R.id.fab_addHome)

        btn_settingsHome.setOnClickListener {
            val intent = Intent(this@Home, settings::class.java)
            startActivity(intent)
            finish()
        }

        btn_profileHome.setOnClickListener{
            val intent = Intent(this@Home, profile::class.java)
            startActivity(intent)
            finish()
        }

        lin_savedDesigns.setOnClickListener {
            val intent = Intent(this@Home, savedDesign::class.java)
            startActivity(intent)
            finish()
        }

        lin_drafts.setOnClickListener{
            val intent = Intent(this@Home, drafts::class.java)
            startActivity(intent)
            finish()
        }

        lin_library.setOnClickListener{
            val intent = Intent(this@Home, library::class.java)
            startActivity(intent)
            finish()
        }

        lin_explore.setOnClickListener {
            val intent = Intent(this@Home, explore::class.java)
            startActivity(intent)
            finish()
        }

        fab_addHome.setOnClickListener {
            val intent = Intent(this@Home, agumentedReality::class.java)
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