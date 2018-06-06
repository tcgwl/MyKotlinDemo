package net.println.kotlin.network.javaandkotlin.kotlincode

fun main(args: Array<String>) {
    //在同模块下用 kotlin 可正常访问 internal 修饰的类与方法
    val internalClass = InternalClass()
    internalClass.printlnHello()
}