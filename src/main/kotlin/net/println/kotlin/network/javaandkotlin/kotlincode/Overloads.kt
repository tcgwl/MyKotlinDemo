package net.println.kotlin.network.javaandkotlin.kotlincode

class Overloads {
    /**
     * 被JvmOverloads标注的方法，其中的默认参数在java中体现为方法重载
     */
    @JvmOverloads
    fun overloaded(a: Int, b: Int = 0, c: Int = 1){
        println("$a, $b, $c")
    }
}