package com.example.grafy_dijkstra_od_nowa

import kotlin.random.Random

data class wierzcholki(val x:Int,val x2: Int, val c:Int)
data class Pio(val r: Int, val c:Int)

class Graph(val nodeCount: Int,val edgeCount: Int) {
    lateinit var LISTA: List<List<Pio>>
    lateinit var wierzcholki: List<wierzcholki>

    constructor(nodeCount: Int = 20, edgeCount: Int = 10, maxEdgeCost: Int = 10) : this(nodeCount,edgeCount) {

        val MUTAAL : List<MutableList<Pio>> = List(nodeCount) { mutableListOf() }
        val mutableEdges = MutableList(edgeCount) { wierzcholki(0, 0, 0) }

        for(i in 0 until edgeCount){

            val x = Random.nextInt(nodeCount)
            val t = Random.nextInt(nodeCount - 1)


            val x2 = if (x >= t) t else (t + 1)

            val c = Random.nextInt(1,maxEdgeCost)

            MUTAAL [x].add(Pio(x2,c))
            MUTAAL [x2].add(Pio(x,c))

            mutableEdges.add(wierzcholki(x,x2,c))

        }

        LISTA = MUTAAL
        wierzcholki = mutableEdges
    }


}