package com.example.introkotlin904

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.Tem2App.ejemplo2
import com.example.introkotlin904.tema1App.Ejemplo1Activity
import com.example.introkotlin904.tema1App.Ejemplo2Activity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btn1 = findViewById<Button>(R.id.btn1);
        val btn2 = findViewById<Button>(R.id.btn2);

        btn1.setOnClickListener{ navigate() }
        btn2.setOnClickListener{ navigateEjemplo2() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigate() {
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }

    private fun navigateEjemplo2() {
        val intent = Intent(this, ejemplo2::class.java)
        startActivity(intent)
    }
}