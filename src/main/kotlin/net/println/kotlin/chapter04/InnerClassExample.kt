package net.println.kotlin.chapter04

/**
 * 内部类
 * 1. 定义在类内部的类
 * 2. 与类成员有相似的访问控制
 * 3. 默认是静态内部类，非静态用 inner 关键字
 * 4. this@Outter, this@Inner 的用法
 *
 * 匿名内部类
 * 1. 没有定义名字的内部类
 * 2. 类名编译时生成，类似 Outter$1.class
 * 3. 可继承父类、实现多个接口，与Java注意区别
 */
open class Outter {
    val a:Int = 0

//    class Inner{ //默认静态内部类
    inner class Inner { //非静态内部类，用 inner 关键字
        val a:Int = 1

        fun hello() {
            println(this@Outter.a)//访问外部类属性
            println(this.a) //访问自身属性
        }
    }
}

interface OnClickListener {
    fun onClick()
}

class View {
    var onClickListener: OnClickListener? = null
}

fun main(args: Array<String>) {
    val outter = Outter()
//    val inner = Outter.Inner() //默认静态内部类
    val inner = outter.Inner() //非静态内部类
    inner.hello()

    val view = View()
    view.onClickListener = object : Outter(), OnClickListener { //匿名内部类
        override fun onClick() {

        }
    }
}