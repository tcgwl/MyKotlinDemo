package net.println.kotlin.chapter05

import java.io.BufferedReader
import java.io.FileReader

/**
 * 常见高阶函数
 * 1. map/flatMap
 * 2. fold/reduce
 * 3. filter/takeWhile
 * 4. let/apply/with/use
 */
fun main(args: Array<String>) {
    val list = listOf(1,3,5,7,9)

    val newList = ArrayList<Int>()
    list.forEach {
        var newElement = it * 2 + 3
        newList.add(newElement)
    }
    newList.forEach(::println)

    val newList2 = list.map {
        it * 2 + 3
    }
    newList2.forEach(::println)
//    5
//    9
//    13
//    17
//    21

    val newList3 = list.map(Int::toDouble)
    newList3.forEach(::println)
//    1.0
//    3.0
//    5.0
//    7.0
//    9.0

    val list2 = listOf(
            1..10,
            2..5,
            100..110
    )
    val flatList = list2.flatMap {
        it
    }
    flatList.forEach(::println)

//    val flatList2 = list2.flatMap {
//        it.map {
//            "No. $it"
//        }
//    }
    val flatList2 = list2.flatMap { intRange ->
        intRange.map { intElement ->
            "No. $intElement"
        }
    }
    flatList2.forEach(::println)

    println(flatList.reduce { acc, i -> acc + i }) //1224

    (0..6).map(::factorial).forEach(::println)
//    1
//    1
//    2
//    6
//    24
//    120
//    720

    println((0..6).map(::factorial).reduce { acc, i -> acc + i }) //874

    println((0..6).map(::factorial).fold(5){acc, i ->
        acc + i
    }) //879

    println((0..6).joinToString(",")) //0,1,2,3,4,5,6

    println((0..6).map(::factorial).fold(StringBuilder()){acc, i ->
        acc.append(i).append(",")
    }) //1,1,2,6,24,120,720,

    println((0..6).map(::factorial).foldRight(StringBuilder()){i, acc ->
        acc.append(i).append(",") //720,120,24,6,2,1,1,
    })

    println((0..6).map(::factorial).filter { it % 2 == 1 }) //取所有奇数 [1, 1]
    println((0..6).map(::factorial).takeWhile { it < 30 }) //取小于30的数 [1, 1, 2, 6, 24]

    findPerson()?.let { person ->
        person.work()
        println(person.name)
        println(person.age)
    }
    findPerson()?.apply {
        work()
        println("$name---$age")
    }

    val br = BufferedReader(FileReader("Hello.txt"))
    with(br) {//相当于在BufferedReader的作用域范围之内，readLine()和close()都属于BufferedReader的方法
        var line: String?
        while (true) {
            line = readLine()?: break
            println(line)
        }
        close()
    }
//    println(BufferedReader(FileReader("Hello.txt")).readText())

    BufferedReader(FileReader("Hello.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine()?: break
            println(line)
        }
    }
}

fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}

data class Person(val name: String, val age: Int) {
    fun work() {
        println("$name is working.")
    }
}

fun findPerson(): Person? {
    return Person("Tom", 23)
}