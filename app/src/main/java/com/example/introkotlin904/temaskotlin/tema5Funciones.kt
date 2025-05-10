package com.example.introkotlin904.temaskotlin

fun suma(a: Int, b: Int){
    println("La suma de $a y $b es ${a+b}")
}

fun saludo(){
    println("Hola Mundo")
}

fun resta(a: Int, b: Int):Int{
    return a-b
}

fun resta2(a:Int, b:Int)=a-b

fun main(){
    saludo();
    suma(3, 5)
    println("La resta de 5-3 es ${resta(5,3)}")
}

