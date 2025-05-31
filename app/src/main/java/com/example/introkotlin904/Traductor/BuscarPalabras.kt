package com.example.introkotlin904.Traductor

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
import java.io.FileNotFoundException

class BuscarPalabras : AppCompatActivity() {
    public val filename ="palabras.txt";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabras)
        val rbtEspanol = findViewById<android.widget.RadioButton>(R.id.rbtEspanol)
        val rbtIngles = findViewById<android.widget.RadioButton>(R.id.rbtIngles)

        var traduccion = findViewById<TextView>(R.id.lblResultado);
        val palabraTraducir = findViewById<EditText>(R.id.txtPalabraTraducir)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar2)
        val btnBusqueda = findViewById<Button>(R.id.btnBuscador)
        btnRegresar.setOnClickListener {
            val intent = Intent(this@BuscarPalabras, Traductor::class.java)
            startActivity(intent)
        }
        btnBusqueda.setOnClickListener {
            val palabra = palabraTraducir.text.toString().trim()
            var encontrado = false

            if (palabra.isEmpty()) {
                Toast.makeText(this, "Ingresa una palabra para buscar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                openFileInput(filename).bufferedReader().useLines { lines ->
                    lines.forEach { linea ->
                        val partes = linea.split("-")
                        if (partes.size == 2) {
                            val espanol = partes[0].trim()
                            val ingles = partes[1].trim()

                            if (rbtEspanol.isChecked && palabra.equals(espanol, ignoreCase = true)) {
                                traduccion.text = ingles
                                encontrado = true
                                return@forEach
                            } else if (rbtIngles.isChecked && palabra.equals(ingles, ignoreCase = true)) {
                                traduccion.text = espanol
                                encontrado = true
                                return@forEach
                            }
                        }
                    }
                }

                if (!encontrado) {
                    traduccion.text = ""
                    Toast.makeText(this, "No se encontró la palabra", Toast.LENGTH_SHORT).show()
                }
            } catch (e: FileNotFoundException) {
                Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Ocurrió un error", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}