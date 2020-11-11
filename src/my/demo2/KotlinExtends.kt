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
    open fun draw() { /*……*/ }
    fun fill() { /*……*/ }
}

class Circle() : Shape() {
    override fun draw() { /*……*/ }
}