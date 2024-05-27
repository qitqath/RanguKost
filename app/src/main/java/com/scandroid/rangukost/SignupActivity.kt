package com.scandroid.rangukost

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import com.scandroid.rangukost.R

class SignupActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSignup: Button
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSignup = findViewById(R.id.btnSignup)
        btnLogin = findViewById(R.id.btnLogin)

        btnSignup.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    // Lakukan proses pendaftaran di sini
                    // Misalnya, Anda dapat memanggil metode dari repository atau ViewModel
                    // untuk menyimpan informasi pendaftaran ke database atau backend

                    // Setelah pendaftaran berhasil, arahkan ke MainActivity
                    val intent = Intent(this@SignupActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Selesai dengan SignupActivity
                } else {
                    // Jika password dan konfirmasi password tidak sesuai, tampilkan pesan kesalahan
                    Toast.makeText(this@SignupActivity, "Password and confirm password do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Jika ada bidang yang kosong, tampilkan pesan kesalahan
                Toast.makeText(this@SignupActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }


        btnLogin.setOnClickListener {
            // Start LoginActivity when login button is clicked
            finish() // Finish SignupActivity to prevent going back to it when pressing back button
        }
    }
}
