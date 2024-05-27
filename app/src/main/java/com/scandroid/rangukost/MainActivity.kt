package com.scandroid.rangukost

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        welcomeTextView = findViewById(R.id.welcomeTextView)

        // Retrieve User data from Intent
        val user = intent.getParcelableExtra<User>("USER")
        user?.let {
            welcomeTextView.text = "We're so excited to welcome you, ${it.username}!"
        }

        val btnResiIntent: Button = findViewById(R.id.btn_residents)
        btnResiIntent.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_residents -> {
                val moveIntent = Intent(this@MainActivity, PageActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
