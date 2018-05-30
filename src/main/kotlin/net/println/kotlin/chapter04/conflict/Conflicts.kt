package net.println.kotlin.chapter04.conflict

/**
 * 继承(实现)语法要点
 * 1.父类需要open才可以被继承
 * 2.父类方法、属性需要open才可以被覆写
 * 3.接口、接口方法、抽象类默认为open
 * 4.覆写父类(接口)成员需要override关键字
 * 5.class D: A(), B, C
 * 6.注意继承类时实际上调用了父类的构造方法
 * 7.类只能单继承，接口可以多实现
 *
 * 接口方法冲突
 * 1.接口方法可以有默认实现
 * 2.签名一致且返回值相同的冲突
 * 3.子类(实现类)必须覆写冲突方法
 * 4.super<[父类(接口)名]>.[方法名]([参数列表])
 */
abstract class A {
    open fun x(): String = "良"
}

interface B {
    fun x(): String = "好"
}

interface C {
    fun x(): String = "及格"
}

class D(private var y: Int = 60): A(), B, C {
    override fun x(): String {
        println("call x() in D")
        return when {
            y > 90 -> "优"
            y > 80 -> super<A>.x()
            y > 70 -> super<B>.x()
            y >= 60 -> super<C>.x()
            else -> "不及格"
        }
    }

}

fun main(args: Array<String>) {
    println(D(91).x())
    println(D(86).x())
    println(D(76).x())
    println(D(68).x())
    println(D(59).x())
}