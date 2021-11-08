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
        val button = findViewById<ImageButton>(R.id.button)
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

        var secuencia7: List<ImageButton> = listOf(rojo, verde, azul, amarillo)
        var secuencia: MutableList<ImageButton> = mutableListOf()
        for (i in 1..Ronda + 1) {
            secuencia.add(secuencia7.random())
        }



        suspend fun color() {
            var delay = 0
            for (i in 0..secuencia.size - 1) {
                delay(delay + 500L);
                val color1 = secuencia[i].setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
                delay(500L)

                val color2 = secuencia[i].clearColorFilter()
            }
        }


        val job1 = GlobalScope.launch(Dispatchers.Main) { color() }


        var cont = 0
        var secuencianueva = mutableListOf<ImageButton>()
        rojo.setOnClickListener {
            suspend fun parpadeo_rojo() {
                rojo.setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
                delay(200L)

                rojo.clearColorFilter()
            }

            val job1 = GlobalScope.launch(Dispatchers.Main) { parpadeo_rojo() }
            secuencianueva.add(rojo)
            cont = cont + 1
            if (cont == secuencia.size) {
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
                    Ronda = 1
                    mostrarRonda()

                }
            }
        }
        verde.setOnClickListener {
            suspend fun parpadeo_verde() {
                verde.setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
                delay(200L)

                verde.clearColorFilter()
            }

            val job1 = GlobalScope.launch(Dispatchers.Main) { parpadeo_verde() }

            secuencianueva.add(verde)
            cont = cont + 1
            if (cont == secuencia.size) {
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
                    Ronda = 1
                    mostrarRonda()


                }
            }
        }
        azul.setOnClickListener {
            suspend fun parpadeo_azul() {
                azul.setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
                delay(200L)

                azul.clearColorFilter()
            }

            val job1 = GlobalScope.launch(Dispatchers.Main) { parpadeo_azul() }
            azul.setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
            secuencianueva.add(azul)
            cont = cont + 1
            if (cont == secuencia.size) {
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
                    Ronda = 1
                    mostrarRonda()

                }
            }
        }
        amarillo.setOnClickListener {
            suspend fun parpadeo_amarillo() {
                amarillo.setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
                delay(200L)

                amarillo.clearColorFilter()
            }

            val job1 = GlobalScope.launch(Dispatchers.Main) { parpadeo_amarillo() }
            amarillo.setColorFilter(Color.WHITE, PorterDuff.Mode.OVERLAY);
            secuencianueva.add(amarillo)
            cont = cont + 1
            if (cont == secuencia.size) {
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
                    Ronda = 1
                    mostrarRonda()

                }
            }
        }
        var toast =
            Toast.makeText(applicationContext, "Repite la secuencia", Toast.LENGTH_LONG).show()


    }


}
