package net.println.kotlin.network.kotlininvokejava.kotlincode

/**
 * 在kotlin中同步方法使用@Synchronized
 * 用@Volatile替代java中的volatile
 */
@Volatile var count: Int = 0

fun count(){
    synchronized(count){
        count++
    }
}