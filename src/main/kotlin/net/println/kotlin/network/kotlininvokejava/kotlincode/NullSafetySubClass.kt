package net.println.kotlin.network.kotlininvokejava.kotlincode

import net.println.kotlin.network.kotlininvokejava.javacode.NullSafetyAbsClass
import java.util.*

class NullSafetySubClass : NullSafetyAbsClass(){
    override fun formatDate(date: Date): String {
        return date.toString()
    }
}

fun main(args: Array<String>) {
    val nullSafetySubClass = NullSafetySubClass()
    println(nullSafetySubClass.formatDate(Date()))
    println(nullSafetySubClass.formatTime(Date()))
}