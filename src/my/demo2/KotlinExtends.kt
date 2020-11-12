package my.demo2

//在 Kotlin 中所有类都有一个共同的超类 Any，这对于没有超类型声明的类是默认超类：
//Any 有三个方法：equals()、 hashCode() 与 toString()。因此，为所有 Kotlin 类都定义了这些方法。
//
//默认情况下，Kotlin 类是最终（final）的：它们不能被继承。 要使一个类可继承，请用 open 关键字标记它
class Example{

}
open class Base(p: Int)

class Derived(p: Int) : Base(p)

//如果派生类有一个主构造函数，其基类可以（并且必须）
//用派生类主构造函数的参数就地初始化。

//如果派生类没有主构造函数，那么每个次构造函数必须使用super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
//注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：
//如果派生类有一个主构造函数，其基类可以（并且必须） 用派生类主构造函数的参数就地初始化。
//如果派生类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
//注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：
class View {
    constructor(ctx: Int)

    constructor(ctx: Int, attrs: Int)
}

//class MyView(p : Int) : View(p) {
//    constructor(ctx: Int) : super(ctx)
//
//    constructor(ctx: Int, attrs: Int) : super(ctx, attrs)
//}

//覆盖方法
open class Shape {
    open val vertexCount: Int = 0
    open fun draw() { /*……*/ }
    fun fill() { /*……*/ }
}

class Circle() : Shape() {
    override val vertexCount = 4
    override fun draw() { /*……*/ }
}

//覆盖属性
//你也可以用一个 var 属性覆盖一个 val 属性，但反之则不行。
// 这是允许的，因为一个 val 属性本质上声明了一个 get 方法， 而将其覆盖为 var 只是在子类中额外声明一个 set 方法。
interface Shape2 {
    val vertexCount: Int
}

class Rectangle(override val vertexCount: Int = 4) : Shape2 // 总是有 4 个顶点

class Polygon : Shape2 {
    override var vertexCount: Int = 0  // 以后可以设置为任何数
}

//派生类初始化顺序
//在构造派生类的新实例的过程中，第一步完成其基类的初始化
//（在之前只有对基类构造函数参数的求值），因此发生在派生类的初始化逻辑运行之前。
open class Base2(val name: String) {



    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
    init { println("Initializing Base") }
}

class Derived2(
    name: String,
    val lastName: String
) : Base2(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

//这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
//如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）
//使用了任何一个这种属性，那么都可能导致不正确的行为或运行时故障。
//设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。todo
fun main(){
    val shape = Shape();
    val circle = Circle();

    shape.draw()
    circle.draw()

    val rectangle = Rectangle();
    System.out.println(rectangle.vertexCount)
    val polygon = Polygon();
    System.out.println(polygon.vertexCount)

    Derived2("test derived", "lastname")
}

//覆盖方法
open class Shape3 {
    open val vertexCount: Int = 0
    open val borderColor : String get() = "white"
    open fun draw() { println("shape3 println") }
    fun fill() { /*……*/ }
}

class Rectangle2() : Shape3() {
    override val vertexCount = 4
    override fun draw() { /*……*/ }
}

class FilledRectangle: Shape3() {
    override fun draw() {
        println("FilledRectangle print ok")
    }
    override val borderColor: String get() = "black"

    inner class Filler {
        fun fill() { /* …… */ }
        fun drawAndFill() {
            super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
        }
    }
}

//覆盖规则
//在 Kotlin 中，实现继承由下述规则规定：
//如果一个类从它的直接超类继承相同成员的多个实现， 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
//为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>
open class Rectangle4 {
    open fun draw() { /* …… */ }
}

interface Polygon4 {
    fun draw() { /* …… */ } // 接口成员默认就是“open”的
}

class Square4() : Rectangle4(), Polygon4 {
    // 编译器要求覆盖 draw()：
    override fun draw() {
        super<Rectangle4>.draw() // 调用 Rectangle.draw()
        super<Polygon4>.draw() // 调用 Polygon.draw()
    }
}

//抽象类
//类以及其中的某些成员可以声明为 abstract。
//抽象成员在本类中可以不用实现。
//需要注意的是，我们并不需要用 open 标注一个抽象类或者函数——因为这不言而喻。
//我们可以用一个抽象成员覆盖一个非抽象的开放成员

//类可以包含：
//
//构造函数与初始化块
//函数
//属性
//嵌套类与内部类
//对象声明

open class Polygon5 {
    open fun draw() {}
}

abstract class Rectangle5 : Polygon5() {
    abstract override fun draw()
}