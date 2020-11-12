package my.demo2

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

/* 注释从这里开始
   /* 包含嵌套的注释 */
     并且在这里结束。
*/
class KotlinVar {
    //顶层变量
    val PI = 3.14
    var x = 0
    fun incrementX() {
        x += 1
    }
}
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun parseInt(str: String): Int? {
    // ……
    var a = Integer.parseInt(str)
    println("parse int $a")
//    return null
    return a
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println("printProduct , ${x * y}")
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }
}
fun printProduct2(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // ……
    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }

    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // 在空检测后，x 与 y 会自动转换为非空值
    println("printProduct2 , ${x * y}, $x")
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` 在该条件分支内自动转换成 `String`
        return obj.length
    }

    // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
    return null
}
fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` 在这一分支自动转换为 `String`
    return obj.length
}
fun getStringLength3(obj: Any): Int? {
    // `obj` 在 `&&` 右边自动转换成 `String` 类型
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}
fun main(){
    //定义的只读局部变量
        val a : Int = 1 //立即赋值
        val b = 2      //自动推断出int类型
        val c: Int  //如果没有初始值类型不能省略
        c = 3         //明确赋值

    //可以重新赋值的变量使用var
        var x = 5 //自动推断出int类型
        x += 1
        println(x)

    // 字符串模板
        var astr = 1
        // 模板中的简单名称：
        val s1 = "a is $astr"

        astr = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s2)

    // 条件表达式
       println(max(1,5))
       fun maxOf2(a: Int, b: Int) = if (a > b) a else b
       println(maxOf2(3,7))

    // 空值与 null 检测 todo
      //当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
      //如果 str 的内容不是数字返回 null：
      println(printProduct("12", "23"))
      println(printProduct2("12", "23"))

    //类型检测与自动类型转换
    //is 运算符检测一个表达式是否某类型的一个实例。
    //如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的分支中可以直接当作该类型使用，无需显式转换：
    println("getStringLength ${getStringLength(123)}, ${getStringLength2(123)}, ${getStringLength("123")}, ${getStringLength2("123")}")

    //for循环
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    val items2 = listOf("apple", "banana", "kiwifruit")
    for (index in items2.indices) {
        println("item2 at $index is ${items2[index]}")
    }
    //返回了一个新的字符串
    println(items2[1].reversed())
    //==返回true
    println(items == items2)

    val items3 = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items3.size) {
        println("item3 at $index is ${items3[index]}")
        index++
    }

    // while循环
    val itemsW = listOf("apple", "banana", "kiwifruit")
    var indexW = 0
    while (indexW < itemsW.size) {
        println("itemW at $indexW is ${itemsW[indexW]}")
        indexW++
    }

    //when表达式
    fun describe(obj: Any): String =
            when (obj) {
                1          -> "One"
                "Hello"    -> "Greeting"
                is Long    -> "Long"
                !is String -> "Not a string"
                else       -> "Unknown"
            }
    println("when expression is :${describe(1)}")

    //使用区间
    //使用 in 运算符来检测某个数字是否在指定区间内：
    checkRange()

    //使用区间
    checkInterval()

    //集合操作
    checkCollection()
}

fun checkCollection(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

fun checkRange(){
    println("-----check range-----")
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun checkInterval(){
    println("-----check interval-----")
    for (x in 1..5) {//// 等同于 1 <= i && i <= 4
        print(x)
    }
    println()
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
    println()
    for (i in (1 until 10 ).reversed()) {       // i in [1, 10), 10被排除
        print(i)
    }

//    val versionRange = Version(1, 11)..Version(1, 30)
//    println(Version(0, 9) in versionRange)
//    println(Version(1, 20) in versionRange)
    println()
    println((1..10).filter { it % 2 == 0 })

    //兼容了java功能
    var li = Arrays.asList(1,2,3);
    for(item in li){
        System.out.println(item)
    }
}

//fun aop(function: Function){
//    println("------${function}-----")
//}