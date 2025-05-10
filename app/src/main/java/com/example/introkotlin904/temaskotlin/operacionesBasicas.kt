package com.example.introkotlin904.temaskotlin

fun main(){
    var continuar: Boolean = true
    while(continuar) {
        println("Introduce la operación a realizar")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        var operacion = readln();

        if (operacion.equals("5")){
            continuar=false
        } else {
            println("Introduce el primer valor")
            val num1 = readln().toDouble()
            println("Introduce el segundo valor")
            val num2 = readln().toDouble()

            when(operacion){
                "1" -> println("La suma de los dos números es: ${sumar(num1, num2)}")
                "2" -> println("La resta de los dos números es: ${restar(num1, num2)}")
                "3" -> println("La multiplicación de los dos números es: ${multiplicar(num1, num2)}")
                "4" -> println("La división de los dos números es: ${dividir(num1, num2)}")
            }
        }
    }
}

fun sumar(a: Double, b:Double): Double{
    return a+b
}

fun restar(a: Double, b:Double): Double{
    return a-b
}

fun multiplicar(a: Double, b:Double): Double {
    return a * b
}

fun dividir(a: Double, b:Double): Double {
    return a / b
}