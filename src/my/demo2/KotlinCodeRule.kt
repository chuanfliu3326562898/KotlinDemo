package my.demo2

import sun.reflect.generics.tree.ReturnType

//目录结构
//在纯 Kotlin 项目中，推荐的目录结构遵循省略了公共根包的包结构。
//例如，如果项目中的所有代码都位于 org.example.kotlin 包及其子包中，那么 org.example.kotlin 包的文件应该直接放在源代码根目录下，
//而 org.example.kotlin.network.socket 中的文件应该放在源代码根目录下的 network/socket 子目录中。
//
//对于 JVM 平台：Kotlin 源文件应当与 Java 源文件位于同一源文件根目录下，
//并遵循相同的目录结构（每个文件应存储在与其 package 语句对应的目录中。

// 源文件名称
//如果 Kotlin 文件包含单个类（以及可能相关的顶层声明），那么文件名应该与该类的名称相同，并追加 .kt 扩展名。
// 如果文件包含多个类或只包含顶层声明， 那么选择一个描述该文件所包含内容的名称，并以此命名该文件。
// 使用首字母大写的驼峰风格（例如 ProcessDeclarations.kt）。
//文件的名称应该描述文件中代码的作用。因此，应避免在文件名中使用诸如“Util”之类的无意义词语。

//如果 Kotlin 文件包含单个类（以及可能相关的顶层声明），那么文件名应该与该类的名称相同，并追加 .kt 扩展名。
//如果文件包含多个类或只包含顶层声明， 那么选择一个描述该文件所包含内容的名称，并以此命名该文件。
//使用首字母大写的驼峰风格（例如 ProcessDeclarations.kt）。
//文件的名称应该描述文件中代码的作用。因此，应避免在文件名中使用诸如“Util”之类的无意义词语。

//源文件组织
//鼓励多个声明（类、顶级函数或者属性）放在同一个 Kotlin 源文件中，
//只要这些声明在语义上彼此紧密关联并且文件保持合理大小 （不超过几百行）。
//特别是在为类定义与类的所有客户都相关的扩展函数时，
//请将它们放在与类自身定义相同的地方。
//而在定义仅对指定客户有意义的扩展函数时，请将它们放在紧挨该客户代码之后。
//不要只是为了保存 “Foo 的所有扩展函数”而创建文件。

//类布局
//通常，一个类的内容按以下顺序排列：
//
//属性声明与初始化块
//次构造函数
//方法声明
//伴生对象
//不要按字母顺序或者可见性对方法声明排序，也不要将常规方法与扩展方法分开。而是要把相关的东西放在一起，这样从上到下阅读类的人就能够跟进所发生事情的逻辑。选择一个顺序（高级别优先，或者相反）并坚持下去。
//
//将嵌套类放在紧挨使用这些类的代码之后。如果打算在外部使用嵌套类，而且类中并没有引用这些类，那么把它们放到末尾，在伴生对象之后。
class KotlinCodeRule {
    val size : Int = 0
    val isEmpty: Boolean get() = size == 0
    var isFull : Boolean set()
    // 格式化控制流语句
//    if (!component.isSyncing &&
//    !hasAnyKotlinRuntimeInScope(module)
//    ) {
//        return createKotlinNotConfiguredPanel(module)
//    }

//    private fun parsePropertyValue(propName: String, token: Token) {
//        when (token) {
//            is Token.ValueToken ->
//                callback.visitValue(propName, token.value)
//
//            Token.LBRACE -> { // ……
//            }
//        }
//    }


}

fun main(){
    val sum: (Int, Int, Int) -> Int = fun(
            x,
            y,
            z // trailing comma
    ): Int {
        return x + y + x
    }
    println(sum(8, 8, 8))

    //将短分支放在与条件相同的行上，无需花括号。
    val foo : Boolean = true
    when (foo) {
        true -> 1 // 良好
        false -> { 2 } // 不良
    }

    //链式调用换行
//    val anchor = owner
//            ?.firstChild!!
//            .siblings(forward = true)
//            .dropWhile { it is PsiComment || it is PsiWhiteSpace }

    // 不良：arrayListOf() 返回 ArrayList<T>，这是一个可变集合类型
    val allowedValues1 = arrayListOf("a", "b", "c")

// 良好：listOf() 返回 List<T>
    val allowedValues = listOf("a", "b", "c")

    println(allowedValues == allowedValues1)

//    使用作用域函数 apply/with/run/also/let

    val  a : Double = Double.MAX_VALUE
    val  b : Double = Double.MIN_VALUE
    println(a)
    println(b)

    val d = 1
}
//函数格式化
//fun longMethodName(
//        argument: ArgumentType = defaultValue,
//        argument2: AnotherArgumentType,
//): ReturnType {
//    // 函数体
//}