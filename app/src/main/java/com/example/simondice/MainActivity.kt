package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.simondice.R.id.imageButton2

class MainActivity : AppCompatActivity() {
    var Ronda=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button= findViewById<Button>(R.id.button)
button.setOnClickListener {jugar()}
    }




    fun jugar(){Ronda=Ronda+1; mostrarRonda();ejecutarSecuencia();var toast=Toast.makeText(applicationContext,"Repite la secuencia",Toast.LENGTH_LONG).show()}
    fun mostrarRonda(){findViewById<TextView>(R.id.textView2).setText(Ronda)}

    fun ejecutarSecuencia(){
     val boton1=findViewById<ImageButton>(R.id.imageButton);
     val boton2=findViewById<ImageButton>(imageButton2);
     val boton3=findViewById<ImageButton>(R.id.imageButton3);
     val boton4=findViewById<ImageButton>(R.id.imageButton4);

     val secuencia= arrayOf(boton1,boton2,boton3,boton4).shuffle();

 }


}