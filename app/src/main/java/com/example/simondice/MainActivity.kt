package com.example.simondice

import android.graphics.Color
import android.graphics.PorterDuff
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Delayed

class MainActivity : AppCompatActivity() {
    var Ronda = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { jugar() }
    }

    fun jugar() {
        Log.i("estado", "empieza el juego")
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

        val secuencia: List<ImageButton> = listOf(rojo, verde, azul, amarillo).shuffled()

        suspend fun color1() {
            delay(500L);
            val color1 = secuencia[0].setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
            delay(500L)

            val color2 = secuencia[0].clearColorFilter()

        }

        suspend fun color2() {
            delay(1000L);
            val color1 = secuencia[1].setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
            delay(500L)
            val color2 = secuencia[1].clearColorFilter()
        }

        suspend fun color3() {
            delay(1500L);
            val color1 = secuencia[2].setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
            delay(500L)

            val color2 = secuencia[2].clearColorFilter()
        }

        suspend fun color4() {
            delay(2000L);
            val color1 = secuencia[3].setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
            delay(500L)

            val color2 = secuencia[3].clearColorFilter()
        }

        val job1 = GlobalScope.launch(Dispatchers.Main) { color1() }
        val job2 = GlobalScope.launch(Dispatchers.Main) { color2() }
        val job3 = GlobalScope.launch(Dispatchers.Main) { color3() }
        val job4 = GlobalScope.launch(Dispatchers.Main) { color4() }
        var cont = 0
        var secuencianueva = mutableListOf<ImageButton>()
        rojo.setOnClickListener {
            secuencianueva.add(rojo)
            cont = cont + 1
            if (cont == 4) {
                if (secuencia == secuencianueva) {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Ganaste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda = Ronda + 1
                    mostrarRonda()
                } else {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Perdiste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda=1
                    mostrarRonda()

                }
            }
        }
        verde.setOnClickListener {
            secuencianueva.add(verde)
            cont = cont + 1
            if (cont == 4) {
                if (secuencia == secuencianueva) {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Ganaste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda = Ronda + 1
                    mostrarRonda()
                } else {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Perdiste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda=1
                    mostrarRonda()


                }
            }
        }
        azul.setOnClickListener {
            secuencianueva.add(azul)
            cont = cont + 1
            if (cont == 4) {
                if (secuencia == secuencianueva) {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Ganaste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda = Ronda + 1
                    mostrarRonda()
                } else {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Perdiste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda=1
                    mostrarRonda()

                }
            }
        }
        amarillo.setOnClickListener {
            secuencianueva.add(amarillo)
            cont = cont + 1
            if (cont == 4) {
                if (secuencia == secuencianueva) {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Ganaste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda = Ronda + 1
                    mostrarRonda()
                } else {
                    var toast =
                        android.widget.Toast.makeText(
                            applicationContext,
                            "Perdiste",
                            android.widget.Toast.LENGTH_LONG
                        ).show()
                    Ronda=1
                    mostrarRonda()

                }
            }
        }
        var toast =
            Toast.makeText(applicationContext, "Repite la secuencia", Toast.LENGTH_LONG).show()


    }


}
