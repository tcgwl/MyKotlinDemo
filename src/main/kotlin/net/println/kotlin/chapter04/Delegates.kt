package net.println.kotlin.chapter04

import kotlin.reflect.KProperty

/**
 * 属性代理
 * 1. 定义方法
 * - val/var <property name>: <Type> by <expression>
 *   eg:
 *   val e: X by lazy {
 *      println("init X for e")
 *      X()
 *   }
 *
 * 2. 代理者需要实现相应的 setValue/getValue 方法
 * 3. lazy 原理剖析
 */
class Delegates {
    val hello by lazy {
        "HelloWorld"
    }

    val hello2 by X()
    var hello3 by X()
}

class X {
    var value: String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef -> ${property.name}")
        return value?: ""
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue: $thisRef -> ${property.name} = $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello) //HelloWorld
    println(delegates.hello2)
//    getValue: net.println.kotlin.chapter04.Delegates@87aac27 -> hello2
//
    println(delegates.hello3)
//    getValue: net.println.kotlin.chapter04.Delegates@87aac27 -> hello3
//
    delegates.hello3 = "value of hello3"
//    setValue: net.println.kotlin.chapter04.Delegates@87aac27 -> hello3 = value of hello3
}