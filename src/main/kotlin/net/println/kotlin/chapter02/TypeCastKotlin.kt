package net.println.kotlin.chapter02

fun getName(): String? {
    return "thunderHou"
//    return null
}

fun main(args: Array<String>) {
    /*
    空类型和智能类型转换
    val notNull: String = null //错误，不能为空
    val nullable: String? = null //正确，可以为空
    notNull.length //正确，不为空的值可以直接使用
    nullable.length //错误，可能为空，不能直接获取长度
    nullable!!.length //正确，强制认定nullable不可空
    nullable?.length //正确，若nullable为空，返回空
    if (nullable != null) nullable.length //正确
    val sub:SubClass = parent as SubClass //类似Java类型转换，失败抛异常
    val sub:SubClass? = parent as? SubClass //安全类型转换，若失败返回null
    if (parent is SubClass) parent.<子类的成员> //正确
    */

    val name = getName() ?: return
    println(name.length)

    val str: String? = "Hello"
//    if (str != null) {
    if (str is String) {
        println(str.length)
    }

    val parent: Parent = Child()
    if (parent is Child) {
        println(parent.name)
    }

    val parent1: Parent = Parent()
    //as? 避免出现 ClassCastException, 安全的类型转换
    val child: Child? = parent1 as? Child
    println(child)
}