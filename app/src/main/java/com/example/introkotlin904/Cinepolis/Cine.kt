package com.example.introkotlin904.Cinepolis

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Cine : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var nCompradores: EditText
    private lateinit var tarjeta: RadioGroup
    private lateinit var tarjetSi: RadioButton
    private lateinit var tarjetaNo: RadioButton
    private lateinit var nboletos: EditText
    private lateinit var txtTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cine)

        nombre = findViewById(R.id.txtNombre)
        nCompradores = findViewById(R.id.txtNCompradores)
        tarjeta = findViewById(R.id.radioGroup2)
        tarjetSi = findViewById(R.id.radioButtonSi)
        tarjetaNo = findViewById(R.id.radioButtonNo)
        nboletos = findViewById(R.id.txtNBoletos)
        txtTotal = findViewById(R.id.txtTotal)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularBoletos(view: android.view.View) {
        val boletosStr = nboletos.text.toString()
        val compradoresStr = nCompradores.text.toString()

        val boletosInt = boletosStr.toIntOrNull()
        val compradoresInt = compradoresStr.toIntOrNull()

        if (boletosInt == null || compradoresInt == null) {
            txtTotal.text = "Los valores ingresados no son válidos"
            return
        }

        if (compradoresInt == 1 && boletosInt > 7) {
            txtTotal.text = "No puedes comprar más de 7 boletos si solo hay un comprador"
            return
        }

        var descuento = 0
        if (boletosInt > 5) {
            descuento = 15
        } else if (boletosInt > 2) {
            descuento = 10
        }

        val rbSelect = tarjeta.checkedRadioButtonId
        if (rbSelect == tarjetSi.id) {
            descuento += 10
        }

        val precioBoleto = 12.0
        val subtotal = boletosInt * precioBoleto
        val descuentoCalculado = subtotal * descuento / 100
        val total = subtotal - descuentoCalculado

        txtTotal.text =  "$ "+ total
    }
}
