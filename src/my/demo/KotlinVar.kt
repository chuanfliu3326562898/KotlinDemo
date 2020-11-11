package my.demo

class KotlinVar {
    //顶层变量
    val PI = 3.14
    var x = 0


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
    }

}