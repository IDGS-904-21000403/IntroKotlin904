package com.example.introkotlin904.temaskotlin

import kotlin.math.sqrt

fun main(){
    var continuar = 1
    while(continuar == 1) {
        println("Ingresa valor de a")
        var a = readln().toDouble()
        println("Ingresa valor de b")
        var b = readln().toDouble()
        println("Ingresa valor de c")
        var c = readln().toDouble()
        calcularFormula(a, b, c)
        println("¿Deseas continuar?")
        println("1. Si      2. No")
        continuar= readln().toInt();
    }
}

fun calcularFormula(a:Double, b:Double, c:Double){
    var bnegativo = b * -1
    var bcuadrado = b*b
    var calculo = bcuadrado - 4.0 * a *c

    var raiz: Double = sqrt(bcuadrado - 4.0 * a *c)

    if(calculo <0){
        println("Error: la raíz no puede ser negativa")
        return
    }

    var resultAbajo = 2*a
    if(resultAbajo <= 0){
        println("Error: No se pueden realizar divisiones entre 0")
        return
    }

    var primerResultado = (bnegativo + raiz) / resultAbajo
    var segundoResultado = (bnegativo - raiz) / resultAbajo

    println("Primer resultado: $primerResultado")
    println("Segundo resultado: $segundoResultado")

}