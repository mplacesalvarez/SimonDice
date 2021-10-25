package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout.make
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.simondice.R.id.imageButton2

class MainActivity : AppCompatActivity() {
    var Ronda = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { jugar() }
    }

    fun jugar() {
        Log.i("estado","empieza el juego")
        Ronda = Ronda + 1
        mostrarRonda()
        ejecutarSecuencia()

    }

    fun mostrarRonda() {
        val numronda = findViewById<TextView>(R.id.textView2);
        numronda.setText(Ronda.toString())

    }

    fun ejecutarSecuencia() {
        val rojo = findViewById<ImageButton>(R.id.imageButton);
        val verde = findViewById<ImageButton>(imageButton2);
        val azul = findViewById<ImageButton>(R.id.imageButton3);
        val amarillo = findViewById<ImageButton>(R.id.imageButton4);

        val secuencia:List<String> = listOf("rojo", "verde", "azul", "amarillo").shuffled()
        var secuencianueva= mutableListOf<String>()
        var toast1 =
            android.widget.Toast.makeText(applicationContext, secuencia[0].toString(), android.widget.Toast.LENGTH_LONG).show()
        var toast2 =
            android.widget.Toast.makeText(applicationContext, secuencia[1].toString(), android.widget.Toast.LENGTH_LONG).show()
        var toast3 =
            android.widget.Toast.makeText(applicationContext, secuencia[2].toString(), android.widget.Toast.LENGTH_LONG).show()
        var toast4 =
            android.widget.Toast.makeText(applicationContext, secuencia[3].toString(), android.widget.Toast.LENGTH_LONG).show()

        rojo.setOnClickListener {
           secuencianueva.add("rojo")
        }
        verde.setOnClickListener {
            secuencianueva.add("verde")

        }
        azul.setOnClickListener {
            secuencianueva.add("azul")
        }
        amarillo.setOnClickListener {
            secuencianueva.add("amarillo")
        }

        var toast =
            Toast.makeText(applicationContext, "Repite la secuencia", Toast.LENGTH_LONG).show()

    if (secuencia==secuencianueva) {
        var toast =
            android.widget.Toast.makeText(
                applicationContext,
                "Ganaste",
                android.widget.Toast.LENGTH_LONG
            ).show()
    } else {
        var toast =
            android.widget.Toast.makeText(
                applicationContext,
                "Perdiste",
                android.widget.Toast.LENGTH_LONG
            ).show()
        val numronda = findViewById<TextView>(R.id.textView2);

    }




    }


}
