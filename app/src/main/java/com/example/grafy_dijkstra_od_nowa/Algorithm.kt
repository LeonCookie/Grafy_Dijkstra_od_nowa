package com.example.grafy_dijkstra_od_nowa

data class Path(val nodes: List<Int>,val cost: Int)

abstract class Algorithm(val graph: Graph) {

    abstract fun pathfind(s: Int, e:Int):Path?


}