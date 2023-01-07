package com.example.grafy_dijkstra_od_nowa

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var PoczatekNP: NumberPicker
    private lateinit var KoniecNP: NumberPicker
    private lateinit var KosztNP: NumberPicker
    private lateinit var PolaczaenieNP: NumberPicker
    private lateinit var PolaczenieBtn: Button
    private lateinit var StartBtn: Button
    private lateinit var BudowaGraphBtn: Button
    private lateinit var Wynik: TextView
    private lateinit var GraphText: TextView
    private lateinit var graph: Graph

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PoczatekNP = findViewById(R.id.FirstValue)
        KoniecNP = findViewById(R.id.LastValue)
        KosztNP = findViewById(R.id.textVIewNodeCost)
        PolaczaenieNP = findViewById(R.id.Connnected)
        StartBtn = findViewById(R.id.buttonStart)
        BudowaGraphBtn = findViewById(R.id.buttonGraph)
        PolaczenieBtn = findViewById(R.id.buttonConnect)
        Wynik = findViewById(R.id.textViewWynik)
        GraphText = findViewById(R.id.textViewGraphBulid)
        graph = Graph(10, 5, 10)


        BudowaGraphBtn.setOnClickListener {
            GraphText.text = graph.adjacencyList.toString() + '\n' + '\n' + graph.edgesList.toString()
        }


        StartBtn.setOnClickListener {
            val dijkstra: Dijkstra = Dijkstra(graph)
            val path = dijkstra.pathfind(PoczatekNP.value, KoniecNP.value)

            Wynik.text = path.toString()
        }

        PolaczenieBtn.setOnClickListener {
            if (PolaczaenieNP.value == 1) {
                graph.addEdge(PoczatekNP.value, KoniecNP.value, KosztNP.value)
            }
            else {
                graph.removeEdge(PoczatekNP.value, KoniecNP.value, KosztNP.value)
            }
        }

        PoczatekNP.minValue = 0
        PoczatekNP.maxValue = 9
        KoniecNP.minValue = 0
        KoniecNP.maxValue = 9
        KosztNP.minValue = 0
        KosztNP.maxValue = 9
        PolaczaenieNP.minValue = 0
        PolaczaenieNP.maxValue = 1
    }
}