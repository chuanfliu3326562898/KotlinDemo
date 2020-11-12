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

    init { println("Initializing Base") }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}

class Derived2(
    name: String,
    val lastName: String,
) : Base2(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

//这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
//如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）
//使用了任何一个这种属性，那么都可能导致不正确的行为或运行时故障。
//设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
fun main(){
    val shape = Shape();
    val circle = Circle();

    shape.draw()
    circle.draw()

    val rectangle = Rectangle();
    System.out.println(rectangle.vertexCount)
    val polygon = Polygon();
    System.out.println(polygon.vertexCount)
}