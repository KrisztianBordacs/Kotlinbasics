package com.example.kotlinbasics2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GreetingActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var greetingButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var openCalculatorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greeting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.greeting)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //UI elemek inicializálása
        nameEditText = findViewById(R.id.nameEditText)
        greetingButton = findViewById(R.id.greetingButton)
        resultTextView = findViewById(R.id.resultTextView)

        greetingButton.setOnClickListener() {
            val name = nameEditText.text
            if (name.isNotEmpty() && name.isNotBlank()) {
                val greetingText = when {
                    name.length <= 3 -> "Üdv $name, de rövid neved van!"
                    name.length >= 10 -> "Üdv $name, de hosszú neved van!"
                    else -> "Üdv $name!"
                }
                resultTextView.text = greetingText
                nameEditText.setText("")
                hideKeyboard()
            } else {
                //hibaüzenet, ha üres a név
                Toast.makeText(this, "Kérlek add meg a neved!", Toast.LENGTH_SHORT).show()
                //resultTextView.setText("Tölts ki minden mezőt!")
            }
        }


    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(nameEditText.windowToken, 0)
    }
}