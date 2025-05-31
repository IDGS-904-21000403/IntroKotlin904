package com.example.introkotlin904.Traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Traductor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_traductor)

        val btnIrCapturar = findViewById<Button>(R.id.btnCapturar);
        val btnIrBuscar = findViewById<Button>(R.id.btnBuscar)

        btnIrCapturar.setOnClickListener {
            val intent = Intent(this@Traductor, CapturarPalabra::class.java)
            startActivity(intent)
        }

        btnIrBuscar.setOnClickListener {
            val intent = Intent(this@Traductor, BuscarPalabras::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}