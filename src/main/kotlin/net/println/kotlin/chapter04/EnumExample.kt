package net.println.kotlin.chapter04

/**
 * 枚举
 * 1. 实例可数的类，注意枚举也是类
 * 2. 可以修改构造，添加成员
 * 3. 可以提升代码的表现力，也有一定的性能开销
 */
enum class LogLevel(val id: Int) {
    VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), ASSERT(5);

    fun getTag(): String {
        return "$id, $name"
    }

    override fun toString(): String {
        return "$name, $ordinal"
    }
}
//类似枚举写法
class LogLevel2 protected constructor(val id: Int) {
    companion object {
        val VERBOSE = LogLevel2(0)
        val DEBUG = LogLevel2(1)
        val INFO = LogLevel2(2)
        val WARN = LogLevel2(3)
        val ERROR = LogLevel2(4)
        val ASSERT = LogLevel2(5)
    }
}

fun main(args: Array<String>) {
    println(LogLevel.DEBUG)
    println(LogLevel.DEBUG.getTag())
    println(LogLevel.DEBUG.ordinal) //索引
    LogLevel.values().map(::println)

    println(LogLevel.valueOf("ERROR"))
}