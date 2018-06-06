package net.println.kotlin.network.kotlininvokejava.kotlincode

import net.println.kotlin.network.kotlininvokejava.javacode.NullSafetyJava

fun main(args: Array<String>) {
    val nullSafetyJava = NullSafetyJava()
//    val data: String = nullSafetyJava.data //java.lang.IllegalStateException: nullSafetyJava.data must not be null
    val dataCanBeNull: String? = nullSafetyJava.data
    println(dataCanBeNull) //打印: null
}