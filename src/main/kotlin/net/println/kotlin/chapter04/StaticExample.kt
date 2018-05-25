package net.println.kotlin.chapter04

fun main(args: Array<String>) {
    val latitude = Latitude.ofDouble(3.0)
    val latitude2 = Latitude.ofLatitude(latitude)
    println(Latitude.TAG)
}

/**
 * 伴生对象与静态成员
 * 1. 每个类可以对应一个伴生对象companion object
 * 2. 伴生对象的成员全局独一份
 * 3. 伴生对象的成员类似Java的静态成员
 * 4. 静态成员考虑用包级函数、变量替代
 * 5. JvmField 和 JvmStatic 的使用
 */
class Latitude private constructor(val value: Double) {
    //伴生对象
    companion object {
        //在java中访问需要添加@JvmField
        @JvmField
        val TAG: String = "Latitude"
        //在java中访问需要添加@JvmStatic
        @JvmStatic
        fun ofDouble(double: Double): Latitude {
            return Latitude(double)
        }

        fun ofLatitude(latitude: Latitude): Latitude {
            return Latitude(latitude.value)
        }
    }
}