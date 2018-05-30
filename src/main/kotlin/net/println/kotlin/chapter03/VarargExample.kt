package net.println.kotlin.chapter03

/**
 * 变长参数 vararg
 * 1. 某个参数可以接收多个值
 * 2. 可以不为最后一个参数
 * 3. 如果传参时有歧义，需要使用具名参数
 */
fun main(args: Array<String>) {
    val list = arrayListOf(1,3,5,7)
    val intArray = intArrayOf(1,3,5,7)
//    hello(1,3,4,5, string = "hello")//具名参数
    hello(2.5, *intArray, string = "hello")
//    2.5
//    1
//    3
//    5
//    7
//    hello
//    hello(3.0, *list, string = "hello")//错误，不支持list
    hello(ints = *intArray, string = "hello")//默认参数，若有歧义，则需要使用具名参数
//    3.0
//    1
//    3
//    5
//    7
//    hello
    hello(ints = *intArray)
//    3.0
//    1
//    3
//    5
//    7
//    hi
}

fun hello(double: Double = 3.0, vararg ints: Int, string: String = "hi") {
    println(double)
    ints.forEach(::println)
    println(string)
}