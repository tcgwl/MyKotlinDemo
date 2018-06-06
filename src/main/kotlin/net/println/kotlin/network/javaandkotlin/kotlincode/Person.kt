package net.println.kotlin.network.javaandkotlin.kotlincode

/**
 * 被JvmField标注的属性在java中没有setter/getter方法可调用
 */
data class Person(var name:String, @JvmField var age: Int)