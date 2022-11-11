package com.example.grafy_dijkstra_od_nowa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Deklaracje------------------------------
        lateinit var firstNumber: NumberPicker
        lateinit var lastNumber: NumberPicker
        lateinit var ButtonStart: Button
        lateinit var TextResoult: TextView

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
            Log.d("Tag", "Kliknieto przycisk");

        }
    }
}