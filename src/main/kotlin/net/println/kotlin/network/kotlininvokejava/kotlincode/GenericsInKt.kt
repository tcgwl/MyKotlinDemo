package net.println.kotlin.network.kotlininvokejava.kotlincode

//Kotlin 无法写出这样的代码
//abstract class View<P : Presenter<out View<out Presenter<out View<out Presenter>>>{
//    protected abstract val presenter: P
//}
//
//abstract class Presenter<out V : View<out Presenter<out View>>>{
//    protected abstract val view: V
//}

fun main(args: Array<String>) {
    val list = ArrayList<Any>()
    list.add("Hello")
    list.add(0)
    list.map(::println)
}