package net.println.kotlin.chapter03

/**
 * 什么是Lambda表达式
 * 1.匿名函数
 * 2.写法: {[参数列表] -> [函数体，最后一行是返回值]}
 *
 * eg:
val sum = { a:Int, b:Int -> a + b }
调用: sum(2, 3), 相当于sum.invoke(2, 3)
 */
fun main(args: Array<String>) {
    var a = 4
    var b = 5
    println("$a + $b = ${sum(a, b)}")

    sayHi("Harry")
    sayHi2("Lucy")

    println(sum2(2, 3))
    printlnHello()

    for (i in args) {
        println(i)
    }

    println("-------------------")
//    args.forEach { println(it) }
    args.forEach(::println)
    println("-------------------")

//    args.forEach {
//        if (it == "q") return
//        println(it)
//    }

    args.forEach forEach@ {
        if (it == "q") return@forEach
        println(it)
    }

    println("The End")

    println(::sum)
    println(sum2) //Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>
    println(printlnHello is () -> Unit) //true
    println(sayHi2) //Function1<java.lang.String, kotlin.Unit>
}

fun sum(a:Int, b: Int): Int {
    return a + b
}

fun sum1(a: Int, b: Int): Int = a + b

//Lambda表达式
val sum2 = { a:Int, b:Int ->
    println("$a + $b = ${a + b}")
    a + b
}
val printlnHello = {
    println("HelloLambda")
}

fun sayHi(name: String) = println("Hi, $name")

//匿名函数
val sayHi2 = fun(name: String) = println("Hi, $name")