package com.example.lab_3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var editTextLength: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editTextLength = findViewById(R.id.editTextText)
        val generateButton: Button = findViewById(R.id.button)

        generateButton.setOnClickListener {
            val length = editTextLength.text.toString().toIntOrNull() ?: 8
            val password = generatePassword(length)
            textView.text = password
        }
    }

    private fun generatePassword(length: Int): String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}
