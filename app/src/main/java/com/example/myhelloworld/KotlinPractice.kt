package com.example.myhelloworld

fun main() {
//    var a: String = "initial"
//    println(a)
//    val b: Int = 1
//    val c = 3
//    var res: Int = b + c
//    println(res)
    println(printMessage(message = "Hi there! ", greeting = "My friend"))
//    var neverNull: String = "This can't be null!"
//    var nullable: String?  = " You can keep null here"
//    nullable = null
//    println("${neverNull} $nullable")
    function1()
    function2()
    function3()
}

fun printMessage(message: String, greeting: String): String {
    return message + greeting
}

fun function1() {
    for (i in 1..3) {
        println(i)
    }
}

fun function2() {
    for (i in 6 downTo 0 step 2) {
        println(i)
    }
}

fun function3() {
    var x = 10
    while (x > 0) {
        println(x)
        x--
    }
}