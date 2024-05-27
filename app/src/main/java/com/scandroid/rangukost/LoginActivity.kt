package com.scandroid.rangukost

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignup = findViewById(R.id.btnSignup)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == "admin" && password == "password") {
                val user = User(username)
                val intent = Intent(this@LoginActivity, MainActivity::class.java).apply {
                    putExtra("USER", user)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@LoginActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignup.setOnClickListener {
            val moveIntent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(moveIntent)
        }
    }
}
