package net.println.kotlin.chapter02

val arrayOfInt: IntArray = intArrayOf(1,3,5,7)
val arrayOfChar: CharArray = charArrayOf('H','e','l','l','o','W','o','r','l','d')
val arrayOfString: Array<String> = arrayOf("我","是","程序猿")

fun main(args: Array<String>) {
    println(arrayOfInt.size)
    for (int in arrayOfInt) {
        print("$int, ")
    }
    println("\n"+arrayOfString[2]) //程序猿
    println(arrayOfChar.joinToString("")) //HelloWorld
    println(arrayOfChar.joinToString(",")) //H,e,l,l,o,W,o,r,l,d
    println(arrayOfInt.slice(1..2)) //[3, 5]
}