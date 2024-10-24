package com.example.layoutlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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


        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // Set up the adapter for ViewPager2
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Connect the TabLayout and ViewPager2 using TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Kitchen"  // Name of the first tab
                1 -> tab.text = "Living Room"
                2 -> tab.text = "Bathroom"// Name of the second tab
                // Add more cases if you have additional tabs
            }
        }.attach()


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}