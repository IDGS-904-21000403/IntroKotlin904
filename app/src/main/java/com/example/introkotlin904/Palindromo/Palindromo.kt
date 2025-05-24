package com.example.introkotlin904.Palindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R
import com.example.introkotlin904.Tem2App.Resultado

class Palindromo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)
        val ettexto = findViewById<EditText>(R.id.etTexto)
        val btnValidar = findViewById<Button>(R.id.btnVerificar)

        btnValidar.setOnClickListener {
            var texto = ettexto.text.toString();
            var textoReves = "";
            var contVocal = 0;
            var contCons = 0;
            var vocales= "";
            var cons ="";
            var arreglo = texto.toCharArray();

            var bandera = "Verdadero"
            for(i in 0 until arreglo.size){
                var letraFinal = arreglo[arreglo.size - 1 - i]
                if(!arreglo[i].equals(letraFinal)){
                    bandera = "Falso";
                }
                textoReves += letraFinal;

                if(arreglo[i].equals('a') || arreglo[i].equals('e') || arreglo[i].equals('i') || arreglo[i].equals('o') || arreglo[i].equals('u')){
                    contVocal++;
                    vocales += arreglo[i] + " "
                } else {
                    contCons++;
                    cons += arreglo[i] + " "
                }
            }

            if(bandera.equals("Verdadero")){
                Toast.makeText(this, "En efecto la palabra ingresada es palíndromo", Toast.LENGTH_LONG)
                    .show()
                var informe = "Cadena original: " + texto +
                        "\nTexto al revés: " + textoReves +
                        "\nResultado: " + bandera +
                        "\nN vocales: " + contVocal +
                        "\nVocales: " + vocales +
                        "\nN consonantes: " + contCons +
                        "\nConsonantes: " + cons;

                val intent = Intent(this@Palindromo, Informe::class.java)
                intent.putExtra("informe", informe)
                startActivity(intent)
            } else {
                Toast.makeText(this, "La palabra ingresada no es palíndromo", Toast.LENGTH_LONG).show()
            }
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}