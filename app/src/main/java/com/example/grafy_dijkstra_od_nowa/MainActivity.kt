package com.example.grafy_dijkstra_od_nowa

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Deklaracje------------------------------
        lateinit var firstNumber: NumberPicker
        lateinit var lastNumber: NumberPicker
        lateinit var ButtonStart: Button
        lateinit var TextResoult: TextView

        lateinit var GRAPH:Graph

        firstNumber = findViewById(R.id.FirstValue)
        lastNumber = findViewById(R.id.LastValue)
        ButtonStart = findViewById(R.id.buttonStart)
        TextResoult = findViewById(R.id.textViewWynik)
        //Code-----------------------
        firstNumber.minValue = 0;
        firstNumber.maxValue = 9;

        lastNumber.minValue = 0;
        lastNumber.maxValue = 9;
        ButtonStart.setOnClickListener{
            val dijkstra = Dijkstra(GRAPH)
            val path = dijkstra.pathfind(firstNumber.value,lastNumber.value)
            Log.d("Tag", "Kliknieto przycisk");




            TextResoult.text = path?.toString() ?: "Brak sciezki"

        }


        GRAPH = Graph(10,25,10)
    }
}