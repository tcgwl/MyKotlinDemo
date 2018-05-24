package net.println.kotlin.chapter03

class X
/**
 * 定义属性
 * 1，构造方法参数中 val/var 修饰的都是属性
 * 2，类内部也可以定义属性
 * 举例：
 * class Hello(val aField: Int, notAField: Int) {
 *      var anotherField: Float = 3f
 * }
 *
 *
 * 属性初始化
 * 1，属性的初始化尽量在构造方法中完成
 * 2，无法在构造方法中初始化，尝试降级为局部变量
 * 3，var 用 lateinit 延迟初始化，val用 lazy
 * 4，可空类型谨慎使用 null 直接初始化
 */
class KotlinA {
    var b = 0
//        get() {
//            println("someone wants to get b.")
//            return field
//        }
//
//        set(value) {
//            println("someone wants to set b.")
//            field = value
//        }
    lateinit var c: String
    lateinit var d: X
    val e: X by lazy {
        println("init X for e")
        X()
    }
}

fun main(args: Array<String>) {
    println("main start")
    val a = KotlinA()
    println("init a")
    println(a.b)
    println("print a.e")
    println(a.e)
    println("print a.d")
    a.d = X()
    println(a.d)
    println("print a.c")
    println(a.c)//会报错，还未初始化
}