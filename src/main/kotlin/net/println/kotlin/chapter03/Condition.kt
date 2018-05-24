package net.println.kotlin.chapter03

/**
if表达式与完备性
eg: val x = if (b < 0) 0 else b //正确
val x = if (b < 0) 0 //错误, 赋值时, 分支必须完备, 有if有else
when表达式: 加强版switch, 支持任意类型
 */
private const val DEBUG = 1
private const val USER = 0

private const val ADMIN_USER = "admin"
private const val ADMIN_PWD = "admin"

private const val USERNAME = "kotlin"
private const val PASSWORD = "123456"

fun main(args: Array<String>) {
    //val赋值
    val mode= if (args.isNotEmpty() && args[0] == "1") {
        DEBUG
    } else {
        USER
    }

    println("请输入用户名:")
    val username = readLine()
    println("请输入密码:")
    val password = readLine()

    if (mode == DEBUG && username == ADMIN_USER && password == ADMIN_PWD) {
        println("管理员登录成功")
    } else if (username == USERNAME && password == PASSWORD) {
        println("登录成功")
    } else {
        println("登录失败")
    }

    val x = 5
    when(x) {//下面语句顺序执行, 哪个条件满足直接break
        is Int -> println("hell $x")
        in 1..100 -> println("$x is in 1..100")
        !in 1..100 -> println("$x is not in 1..100")
        args[0].toInt() -> println("x == args[0]")
    }

    val tmp = when {
        args.isNotEmpty() && args[0] == "1" -> 1
        else -> 0
    }
    println("tmp=$tmp")
}