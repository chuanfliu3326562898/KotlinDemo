package my.demo2

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
class Bar { }
class Foo { }
//习惯用法
fun main(){

    //检查元素是否存在于集合之中
    val emailsList = listOf("123","234","345","456")
    if ("john@example.com" in emailsList) {  }

    if ("jane@example.com" !in emailsList) {  }

    // 函数的默认参数
    fun foo(a: Int = 0, b: String = "") { }

    //过滤list
    val listDemo = listOf(1,2,3,4)
    val listDemos = listDemo.filter { x -> x > 0 }

    val name  = "test"
    println("Name $name")

    val x : Any = Foo()
    when (x) {
        is Foo -> "1"
        is Bar -> 1.1
        else -> "3"
    }

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((k, v) in map) {
        println("$k -> $v")
    }
    for (i in 1..100) { }  // 闭区间：包含 100
    for (i in 1 until 100) {  } // 半开区间：不包含 100
    for (x in 2..10 step 2) { }
    for (x in 10 downTo 1) {  }
    if (x in 1..10) { }

    val list = listOf("a", "b", "c")

    val map2 = mutableMapOf("a" to 1, "b" to 2, "c" to 3)

    println(map2["key"])
    map2["key"] = 12

    val p: String by lazy {
        // 计算该字符串
    }

    //扩展函数
    fun String.spaceToCamelCase() { …… }

    "Convert this to camelcase".spaceToCamelCase()

    //单例
    object Resource {
        val name = "Name"
    }

    //If not null 缩写
    val files = File("Test").listFiles()
    println(files?.size)

    //If not null and else 缩写
    val files = File("Test").listFiles()
    println(files?.size ?: "empty")

    //if null 执行一个语句
    val values = ……
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")

    //在可能会空的集合中取第一元素
    val emails = …… // 可能会是空集合
    val mainEmail = emails.firstOrNull() ?: ""

    //if not null 执行代码
    val value = ……
    value?.let {
        …… // 代码会执行到此处, 假如data不为null
    }

    val value = ……

    // 映射可空值（如果非空的话）
    val mapped = value?.let { transformValue(it) } ?: defaultValue
    // 如果该值或其转换结果为空，那么返回 defaultValue。

    //返回 when 表达式
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    //“try/catch”表达式
    fun test() : Int {
        val result = try {
            count()
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }

        // 使用 result
    }

    //“if”表达式
    fun foo(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    //返回类型为 Unit 的方法的 Builder 风格用法
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

    //单表达式函数
    fun theAnswer() = 42

    fun transform(color: String): Int = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

//   对一个对象实例调用多个方法 （with）

    class Turtle {
        fun penDown()
        fun penUp()
        fun turn(degrees: Double)
        fun forward(pixels: Double)
    }

    val myTurtle = Turtle()
    with(myTurtle) { // 画一个 100 像素的正方形
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

//    配置对象的属性（apply）
    val myRectangle = Rectangle().apply {
        length = 4
        breadth = 5
        color = 0xFAFAFA
    }

    //这对于配置未出现在对象构造函数中的属性非常有用。
    //Java 7 的 try with resources
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }

    //对于需要泛型信息的泛型函数的适宜形式
     inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)
//     使用可空布尔
    val b: Boolean? = ……
    if (b == true) {
        ……
    } else {
        // `b` 是 false 或者 null
    }

    //交换两个变量
    var a = 1
    var b = 2
    a = b.also { b = a }  //TODO()

//    TODO()：将代码标记为不完整
//    Kotlin 的标准库有一个 TODO() 函数，该函数总是抛出一个 NotImplementedError。 其返回类型为 Nothing，因此无论预期类型是什么都可以使用它。 还有一个接受原因参数的重载：
//
//    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
//    IntelliJ IDEA 的 kotlin 插件理解 TODO() 的语言，并且会自动在 TODO 工具窗口中添加代码指示
}

fun theAnswer(): Int {
    return 42
}