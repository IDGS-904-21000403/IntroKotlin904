package com.example.introkotlin904.Traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class CapturarPalabra : AppCompatActivity() {
    public val filename ="palabras.txt";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabra)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        val textoEsp = findViewById<EditText>(R.id.etEspanol)
        val textoIng = findViewById<EditText>(R.id.etIngles)
        val btnGuardar = findViewById<Button>(R.id.btnSave);

        btnRegresar.setOnClickListener {
            val intent = Intent(this@CapturarPalabra, Traductor::class.java)
            startActivity(intent)
        }

        btnGuardar.setOnClickListener {
            val text = textoEsp.text.toString()+"-"
            val textIng = textoIng.text.toString()+"\n"
            try{
                openFileOutput(filename, MODE_APPEND).use {
                    val linea = "$text-$textIng\n"
                    it.write(linea.toByteArray())
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
            Toast.makeText(this, "Palabras ingresadas con éxitos", Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}