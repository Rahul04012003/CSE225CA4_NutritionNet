package com.example.nutrition

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername: EditText = findViewById(R.id.username)
        val editTextPassword: EditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.login_button)

        sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        loginButton.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Save username and password to shared preferences
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            // Open MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
