package com.example.introkotlin904.temaskotlin
/*
    List
    Mutablelist
    Set
    MutableSet
    Map
    MitableMap




    val figura: mutableFiguras = mutableListOf("cuadrado","triangulo","circulo")
    val readOnlyFiguras = listOf("cuadrado","triangulo","circulo")
    val mutableFiguras = mutableListOf("cuadrado","triangulo","circulo")

    val frutas = setOf("manzana", "bananas", "naranja")
    val frutas = mutableSetOf("manzana", "bananas", "naranja")



*/fun main(){
  /*  val coches = mapOf("uno" to 1, "dos" to 2, "tres" to 3)
    val coches2 = mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(coches2)*/

    val readOnlyFiguras = listOf("cuadrado","triangulo","circulo")
    println(readOnlyFiguras)
    println(" la primera figura es ${readOnlyFiguras[0]}")
    println("el primer elemento es ${readOnlyFiguras.first()}")
    println("numero de elementos ${readOnlyFiguras.count()} items")
    println("circulo" in readOnlyFiguras)
    //readOnlyFiguras.add("pentagono")
    var figura : MutableList<String> = mutableListOf("cuadrado2","triangulo2","circulo2")
    figura.add("pentagono2")
    println(figura)
    figura.remove("cuadrado2")
    println(figura)
}