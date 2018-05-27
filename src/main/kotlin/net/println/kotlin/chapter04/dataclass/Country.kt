package net.println.kotlin.chapter04.dataclass

import net.println.kotlin.chapter04.annotations.Poko

/**
 * 数据类
 * 1. 再见，JavaBean
 * 2. 默认实现copy、toString等方法
 * 3. componentN方法
 * 4. allOpen和noArg插件
 * - allOpen: data class默认是final的，不允许有子类，通过allOpen在编译期修改字节码文件去除final关键字
 * - noArg: 添加无参构造方法
 */
@Poko
data class Country(val id:Int, val name:String)

class ComponentX {
    operator fun component1(): String {
        return "你好，我是"
    }
    operator fun component2(): Int {
        return 1
    }
    operator fun component3(): Int {
        return 1
    }
    operator fun component4(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val china = Country(0, "中国")
    println(china)
    println(china.component1())
    println(china.component2())

    val (id, name) = china
    println(id)
    println(name)

    val componentX = ComponentX()
    val (a,b,c,d) = componentX
    println("$a $b$c$d")
}