package my.demo

import kotlin.text.*
class HelloWorld {
}
//Kotlin 应用程序的入口点是 main 函数
fun main() {
    println("Hello world!")

    fun sum(a : Int, b :Int) = a + b

    printSum(1,2)
}

//函数为
fun sum(a : Int, b : Int) : Int {
    return a + b;
}

fun printSum(a :Int, b: Int) : Unit {
    println("sum of $a and $b is ${a + b}");
}

