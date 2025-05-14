package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo2Activity : AppCompatActivity() {
    private lateinit var et11: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)

        et11 = findViewById<EditText>(R.id.et11)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generarResultado(view: android.view.View){
        var resultado = ""
        val valor1 = et11.text.toString()
        val valor2 = et2.text.toString()

        val valorInt = valor2.toInt()
        for(n in 1 .. valorInt){
            if (n !== valorInt){
                resultado += valor1 + "+"
            } else {
                resultado += valor1
            }
        }
        val multiplicacion = valor1.toInt()*valorInt
        val texto = (resultado + "=" + multiplicacion).toString()
        tv1.text = texto
    }
}