package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var rgb: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var rb4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        rgb = findViewById<RadioGroup>(R.id.radioGroup)
        rb1 = findViewById<RadioButton>(R.id.rb1)
        rb2 = findViewById<RadioButton>(R.id.rb2)
        rb3 = findViewById<RadioButton>(R.id.rb3)
        rb4 = findViewById<RadioButton>(R.id.rb4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View){
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        var resultado = 0;

        val rbSeleccionado = rgb.getCheckedRadioButtonId()

        if(rbSeleccionado == rb1.id){
            resultado = sumar(valor1, valor2)
        } else if(rbSeleccionado == rb2.id){
            resultado = restar(valor1, valor2)
        } else if(rbSeleccionado == rb3.id){
            resultado = multiplicar(valor1, valor2)
        } else {
            resultado = dividir(valor1, valor2)
        }

        tv1.text=resultado.toString()
    }

    fun sumar(valor1: String, valor2: String): Int{
        return valor1.toInt() + valor2.toInt();
    }

    fun restar(valor1: String, valor2: String): Int{
        return valor1.toInt() - valor2.toInt();
    }

    fun multiplicar(valor1: String, valor2: String): Int{
        return valor1.toInt() * valor2.toInt();
    }

    fun dividir(valor1: String, valor2: String): Int{
        return valor1.toInt() / valor2.toInt();
    }
}