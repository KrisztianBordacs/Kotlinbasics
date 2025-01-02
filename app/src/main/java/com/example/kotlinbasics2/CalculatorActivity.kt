package com.example.kotlinbasics2

import android.content.Context
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

class CalculatorActivity : AppCompatActivity() {
    private lateinit var elsoSzamEditText: EditText
    private lateinit var masodikSzamEditText: EditText
    private lateinit var osszeadasButton: Button
    private lateinit var torlesButton: Button
    private lateinit var eredmenyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculator)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //UI Elemek
        elsoSzamEditText = findViewById(R.id.elsoSzamEditText)
        masodikSzamEditText = findViewById(R.id.masodikSzamEditText)
        osszeadasButton = findViewById(R.id.osszeadasButton)
        torlesButton = findViewById(R.id.torlesButton)
        eredmenyTextView = findViewById(R.id.eredmenyTextView)
        val resultString = resources.getString(R.string.eredmeny)
        val toastText = resources.getString(R.string.toastText)

        osszeadasButton.setOnClickListener() {
            val elsoSzam = elsoSzamEditText.text.toString()
            val masodikSzam = masodikSzamEditText.text.toString()
            if(elsoSzam.isNotBlank() && elsoSzam.isNotEmpty() || masodikSzam.isNotBlank() && masodikSzam.isNotEmpty()){
                //var eredmeny = elsoSzam.toInt() + masodikSzam.toInt()
                eredmenyTextView.text = "$resultString  " + szum(elsoSzam.toInt(),masodikSzam.toInt())

                hideKeyboard()
            }else{
                Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
            }
        }
        torlesButton.setOnClickListener() {
            elsoSzamEditText.setText("")
            masodikSzamEditText.setText("")
            eredmenyTextView.text = "$resultString"
        }


    }
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(elsoSzamEditText.windowToken, 0)
        imm.hideSoftInputFromWindow(masodikSzamEditText.windowToken,0)
    }
    private fun szum(a: Int, b: Int): Int {
        return a+b
    }
}