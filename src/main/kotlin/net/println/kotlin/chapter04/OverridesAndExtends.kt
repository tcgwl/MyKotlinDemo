package net.println.kotlin.chapter04

/**
 * 方法重载
 * 1. Override
 * 2. 名称相同，参数不同的方法
 * 3. jvm函数签名的概念：函数名、参数列表
 * 4. 跟返回值没有关系
 *
 * 默认参数
 * 1. 为函数参数设定一个默认值
 * 2. 可以为任意位置的参数设置默认值
 * 3. 函数调用产生混淆时用具名参数
 *
 * 方法重载与默认参数
 * 1. 两者的相关性以及@JvmOverloads(在java代码中调用含默认参数的方法时有用)
 * 2. 避免定义关系不大的重载
 * 不好的设计：
 *  - List.remove(int)
 *  - List.remove(Object)
 *
 *
 *  扩展成员
 *  1. 为现有类添加方法、属性
 *  - fun X.y(): Z {...}
 *  - val X.m 注意扩展属性不能初始化。类似接口属性
 *
 *  2. Java调用扩展成员类似调用静态方法
 */

fun main(args: Array<String>) {
//    println("abc".times(5))
    //等价于
    println("abc" * 5) //abcabcabcabcabc

    println("abc".a) //12345
    println("abc".b) //5
    "abc".b = 8
    println("abc".b) //5，扩展属性不能初始化
}
//扩展方法
//fun String.times(int: Int): String {
//    val stringBuilder = StringBuilder()
//    for (i in 0 until int) {
//        stringBuilder.append(this)
//    }
//    return stringBuilder.toString()
//}

operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}
//扩展属性
val String.a: String
    get() = "12345"

var String.b: Int
    set(value) {
    }
    get() = 5












