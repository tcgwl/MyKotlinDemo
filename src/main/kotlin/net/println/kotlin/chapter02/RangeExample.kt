package net.println.kotlin.chapter02

val range:IntRange = 0..1024    //等价于[0, 1024]
val range2:IntRange = 0 until 1024 //等价于[0, 1024)
val emptyRange:IntRange = 0..-1
val range3: IntRange = 0..9

fun main(args: Array<String>) {
    println(1024 in range)
    println(1024 in range2)
    println(1023 in range2)
    println(emptyRange.isEmpty())
    println(range.contains(50))

    for (i in range3) {
        print("$i, ")
    }
}