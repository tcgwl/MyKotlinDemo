package net.println.kotlin.chapter02

val FINAL_HELLO_WORLD: String = "HelloWorld"//运行时常量
var helloWorld: String? = FINAL_HELLO_WORLD

const val FINAL_HELLO_CHINA = "HelloChina"//编译期常量

//返回值为空，对应类型为Unit，类似Java中的void
fun main(args: Array<String>) {
    println("hello ${args[0]}")
    println(FINAL_HELLO_WORLD)
    println(helloWorld)
    println(FINAL_HELLO_CHINA)
}