package com.example.introkotlin904.temaskotlin

fun main(){
    do {
        println("Dame un numero")
        var num = readln().toInt();
        if(num > 0){
            generarPiramide(num)
        }
    } while (num !== 0)
}

fun generarPiramide(num:Int){
    var asteriscos = ""
    var contador = 0
    do {
        asteriscos+= "*"
        println(asteriscos)
        contador++
    } while (contador < num)
}